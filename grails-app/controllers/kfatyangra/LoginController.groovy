package kfatyangra

class LoginController {

    def index() {
        def plants = Plant.list();
        render(view: '../layouts/homePage', model: [plantList : plants])
    }
    def login(){
        def username = params.login
        def password = params.password
        def mem = Member.findByUsernameAndPassword(username,password);
        if(mem){
            session['name'] = mem?.fullName
            session['id'] = mem?.id
            redirect(action: 'index');
        }
    }
    def logout(){
        def username = session.getAttribute('name')
        session['name'] = ""
        session['id'] = null
        render(view: '../login/login')
    }
}
