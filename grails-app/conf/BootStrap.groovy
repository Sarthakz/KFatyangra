import kfatyangra.Member
import kfatyangra.Role

class BootStrap {

    def init = { servletContext ->
        if(Member.findById(1) == null){
            Member member = new Member();
            member.fullName = "Admin Admin"
            member.password = "admin123"
            member.username = "admin"
            member.role = Role.get(1);
            member.save(flush: true)
        }
    }
    def destroy = {
    }
}
