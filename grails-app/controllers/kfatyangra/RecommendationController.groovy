package kfatyangra

class RecommendationController {
    def recommendService
    def index() {
        render (view: 'index')
    }

    def recommend() {
        def userId = 1
        def user = Member.get(userId as long)
        println params
        def plant = recommendService.serviceMethod(params.plantId as long, user);
        def keys
        def insecticides = []
        if(plant){
            keys = plant.keySet()
            keys.each{ key ->
                insecticides.add(Insecticide.findById(key as long))
            }
        }
        else{
            insecticides = null
        }
        render(template: 'afterRecommendation', model: [list: insecticides])
    }
}
