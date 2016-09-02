package kfatyangra


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MemberController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Member.list(params), model: [memberInstanceCount: Member.count()]
    }

    def show(Member memberInstance) {
        respond memberInstance
    }

    def create() {
        respond new Member(params)
    }

    @Transactional
    def save(Member memberInstance) {
        println "memberInstance = $memberInstance"
        if (memberInstance == null) {
            println "er"
            notFound()
            return
        }
        else{
            println "refe"
            memberInstance.save flush: true, failOnError: true
            println "memberInstance?.fullName = $memberInstance?.fullName" + memberInstance?.username + memberInstance?.password
            render(view: '../login/login')
        }


    }

    def edit(Member memberInstance) {
        respond memberInstance
    }

    @Transactional
    def update(Member memberInstance) {
        if (memberInstance == null) {
            notFound()
            return
        }

        if (memberInstance.hasErrors()) {
            respond memberInstance.errors, view: 'edit'
            return
        }

        memberInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Member.label', default: 'Member'), memberInstance.id])
                redirect memberInstance
            }
            '*' { respond memberInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Member memberInstance) {

        if (memberInstance == null) {
            notFound()
            return
        }

        memberInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Member.label', default: 'Member'), memberInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'memberInstance.label', default: 'Member'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
