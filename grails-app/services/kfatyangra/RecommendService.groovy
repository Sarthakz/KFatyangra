package kfatyangra

import grails.transaction.Transactional

@Transactional
class RecommendService {

    def serviceMethod(plantid,restaurantId, member) {
        def plant = Plant.get(plantid as long)
        def restaurant = Restaurant.get(restaurantId as long)
        def insecticideGroup = [:]
        def insecticides = PlantInsecticide.findAllByPlantAndRestaurant(plant,restaurant)?.insecticide.unique()
        def firstKey
        int size=0
            def sizeInsect = [:]
        insecticides.each{  insect ->
            def userGroup = [:]
            def insecticideList = Rating.findAllByInsecticide(insect)
            if(size < insecticideList.size()){
                size =  insecticideList.size()
                firstKey = insect?.id
            }
            insecticideList.each{  listValue ->
                userGroup[listValue?.memberId] = listValue?.rating
            }
            insecticideGroup[insect?.id] = userGroup
            sizeInsect[insect?.id] = insecticideList.size()
        }
        println insecticideGroup
        def keys =  insecticideGroup.keySet()
        println keys
        def rList = [:]
        rList[firstKey] = 0.00
        keys.each{ key->
            if(key!=firstKey){
                rList[key]=correlationCalculator(insecticideGroup[firstKey],insecticideGroup[key], firstKey, key)
                println rList[key]
            }
        }
        def values = rList.values()
        int i = 0
        boolean choiceOne
        values.each{
            if(it == 0.00){
                i++
            }
        }

        if(i == values.size()){
            sizeInsect = sizeInsect.sort { -it.value }
            return sizeInsect
        }
        else{
            rList = rList.sort{ -it.value }
            return rList
        }
    }
    def correlationCalculator(user1, user2, firstKey, key){
        println  firstKey + " ---------------------- " + key
        def keyList1 = user1?.keySet()
        def keyList2 = user2?.keySet()
        def sameKey  = []
        if(keyList1 && keyList2){
            keyList1.each{ k1->
                keyList2.each{  k2 ->
                    if(k1 == k2){
                        sameKey.add(k1)
                    }
                }
            }
        }
        if(sameKey.size()<1){
            return 0.00
        }
        else{
            double sum1 = 0.00
            double sum1Sq = 0.00
            double sum2 = 0.00
            double sum2Sq = 0.00
            double pSum = 0.00
            sameKey.each{ same->
                sum1 += user1[same]
                sum1Sq = sum1Sq +(user1[same].toString().toDouble() * user1[same].toString().toDouble())
                sum2 += user2[same].toString().toDouble()
                sum2Sq = sum2Sq +(user2[same].toString().toDouble() * user2[same].toString().toDouble())
                pSum = pSum + (user1[same].toString().toDouble() * user2[same].toString().toDouble())
            }
            def num=(pSum-(sum1*sum2/sameKey.size()))
            println "num = $num"
            def den = Math.sqrt(((sum1Sq-(sum1 * sum1))*(sum2Sq-(sum2 * sum2))).doubleValue())
            println "den = $den"
            if(den == 0 || num == 0){
                return 0.00
            }

            def r = num/den
            println "r = $r"
            return r

        }


    }
}
