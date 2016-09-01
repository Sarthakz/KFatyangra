package kfatyangra

class RecommendationController {
    def recommendService
    def index() {}

    def recommend() {
        def userId = session.getAttribute('id')
        def user = Member.get(userId as long)
//        RecommendService recommendService1 = new RecommendService();
//           def plant =

          def plant = recommendService.serviceMethod(params.plantId as long, user);

    }
}
