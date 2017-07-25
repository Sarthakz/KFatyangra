package kfatyangra

class RecommendationController {
    def recommendService
    def index() {
        render (view: 'index')
    }

    def recommend() {
        def usersId = 1
        def user = Member.get(usersId as long)
        println params
        def plant = recommendService.serviceMethod(params.foodId as long,params.restaurantId as long, user);
        def keys
        def insecticides = []
        if(plant){
            keys = plant.keySet()
            keys.each{ key ->
                def insecticide =  Item.findById(key as long)
//                def plantObj = Plant.findById(params.plantId as long)
//                if(PlantInsecticide.findByInsecticideAndMemberAndPlant(insecticide,user,plantObj)){
//                    insecticides.add(insecticide)
//                }
                insecticides.add(insecticide)
            }
        }
        else{
            insecticides = null
        }
        render(template: 'afterRecommendation', model: [list: insecticides])
    }
}
