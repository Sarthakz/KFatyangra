package kfatyangra

import grails.transaction.Transactional

@Transactional
class RecommendService {

    def serviceMethod(plantid,member) {

        def userGroup = [:]
        def insecticideGroup = [:]
        def insecticides = PlantInsecticide.findAllByPlantAndMember(member)
        def insecticideList = Rating.findAllByInsecticideInList(insecticides?.insecticide)
        def insecticides1 = PlantInsecticide.findAllByPlantAndMemberNotEqual(plantid,member)
        def insecticideList1 = Rating.findAllByInsecticideInList(insecticides1?.insecticide)
        def memId = insecticideList1[0]?.memberId
        insecticideList1.each {insecticide ->
            if(insecticide?.memberId == memId){
                insecticideGroup[insecticide?.insecticideId] = insecticide?.rating
            }
            else if(insecticide?.memberId != memId){
                userGroup[memId] = insecticideGroup
            }
        }
    }
}
