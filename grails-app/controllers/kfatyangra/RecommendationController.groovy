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
        def insecticides = Insecticide.findAllByIdBetween(1 as long, 4 as long)
        println "insecticides = $insecticides"
        render(template: 'afterRecommendation', model: [list: insecticides])
    }
}
