package kfatyangra

class LoginController {

    def index() {
        def plants = Plant.list();
//        [plantList : plants]
        redirect(controller: 'recommendation', action: 'index')
    }
    def login(){
        def username = params.username
        def password = params.password

        def mem = Member.findByUsernameAndPassword(username,password);
        println mem
        if(mem){
            session['name'] = mem?.fullName
            session['id'] = mem?.id
            redirect(action: 'index');
        }
        else{
            render(view: 'login')
        }
    }
    def logout(){
        def username = session.getAttribute('name')
        session['name'] = ""
        session['id'] = null
        render(view: '../login/login')
    }
}
