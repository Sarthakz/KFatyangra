package kfatyangra

import grails.transaction.Transactional

@Transactional
class RecommendService {

    def serviceMethod(plantid,member) {
        def plant = Plant.get(plantid as long)
        def userGroup = [:]
        def userGroup1 = [:]
        def insecticideGroup = [:]
        def insecticides = PlantInsecticide.findAllByPlantAndMember(plant,member)
        def insecticideList = Rating.findAllByInsecticideInListAndMember(insecticides?.insecticide,member)
        insecticideList.each{insect ->
            insecticideGroup[insect?.insecticideId] = insect?.rating
        }
        userGroup[member?.id] = insecticideGroup

        def otherMember = Member.findAllByIdNotEqual(member?.id)
        otherMember.each{ itMember ->
            def insecticideGroup1 = [:]
            def insecticides1 = PlantInsecticide.findAllByPlantAndMember(plant,itMember)?.insecticide
            def insecticideList1 = Rating.findAllByInsecticideInListAndMember(insecticides,itMember)
            println insecticideList1
            if(insecticideList1){
                insecticideList1.each{
                    insecticideGroup1[it?.insecticide?.id] = it?.rating
                }
                userGroup1[itMember?.id] = insecticideGroup1
            }
            else{
                userGroup1[itMember?.id] = null
            }
        }
        def keys = userGroup1.keySet()
        def rList = []
        keys.each{
            rList.add(correlationCalculator(userGroup,userGroup1[it],it))
        }
    }
    def correlationCalculator(user1, user2, user2Key){
        def keyList1 = user1?.keySet()
        println keyList1
        def keyList2 = user2?.keySet()
        println "-----" +keyList2
        def sameKey  = []
        if(keyList1 && keyList2){
            keyList1.each{
                keyList2.each{
                    sameKey.add(keyList2)
                }
            }
        }
        if(sameKey.size()<1){
            return 0
        }
        else{
            double sum1 = 0.00
            double sum1Sq = 0.00
            double sum2 = 0.00
            double sum2Sq = 0.00
            double pSum = 0.00
            sameKey.each { same ->
                println user1[same] +"--" +same
                sum1 += user1[same]
                sum1Sq = sum1Sq +(user1[same].toString().toDouble() * user1[same].toString().toDouble())
                sum2 += user2[same].toString().toDouble()
                sum2Sq = sum2Sq +(user2[same].toString().toDouble() * user2[same].toString().toDouble())
                pSum = pSum + (user1[same].toString().toDouble() * user2[same].toString().toDouble())
            }
            def num=(pSum-(sum1*sum2/sameKey.size()))
            def den = Math.sqrt(((sum1Sq-(sum1 * sum1))*(sum2Sq-(sum2 * sum2))).doubleValue())
            if(den < 1 && den > -1){
                return 0.00
            }

            def r = num/den
            return r

        }


    }
}
