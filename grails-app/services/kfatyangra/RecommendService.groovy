package kfatyangra

import grails.transaction.Transactional

@Transactional
class RecommendService {

    def serviceMethod(plantid,member) {
        def plant = Plant.get(plantid as long)
        def userGroup = [:]
        def userGroup1 = [:]
        def insecticideGroup = [:]
        def insecticideGroup1 = [:]
        def insecticides = PlantInsecticide.findAllByPlantAndMember(plant,member)
//        println "insecticides = $insecticides"
        def insecticideList = Rating.findAllByInsecticideInListAndMember(insecticides?.insecticide,member)
//        println "insecticideList = $insecticideList"
        insecticideList.each{insect ->
            insecticideGroup1[insect?.insecticideId] = insect?.rating
        }
        userGroup1[member?.id] = insecticideGroup1
        def insecticides1 = PlantInsecticide.findAllByPlantAndMemberNotEqual(plant,member)
        def insecticideList1 = Rating.findAllByInsecticideInListAndMemberNotEqual(insecticides1?.insecticide,member)
        println "insecticideList1 = $insecticideList1"
        def memId = insecticideList1[0]?.memberId
        insecticideList1.each {insecticide ->
            if(insecticide?.memberId == memId){
                insecticideGroup[insecticide?.insecticideId] = insecticide?.rating
            }
            else if(insecticide?.memberId != memId){
                userGroup[memId] = insecticideGroup
                memId = insecticide?.memberId
            }
        }
        println userGroup
        println userGroup1
    }
}
