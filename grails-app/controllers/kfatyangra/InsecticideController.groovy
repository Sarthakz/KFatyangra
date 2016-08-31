package kfatyangra



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class InsecticideController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Insecticide.list(params), model:[insecticideInstanceCount: Insecticide.count()]
    }

    def show(Insecticide insecticideInstance) {
        respond insecticideInstance
    }

    def create() {
        respond new Insecticide(params)
    }

    @Transactional
    def save(Insecticide insecticideInstance) {
        if (insecticideInstance == null) {
            notFound()
            return
        }

        if (insecticideInstance.hasErrors()) {
            respond insecticideInstance.errors, view:'create'
            return
        }

        insecticideInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'insecticideInstance.label', default: 'Insecticide'), insecticideInstance.id])
                redirect insecticideInstance
            }
            '*' { respond insecticideInstance, [status: CREATED] }
        }
    }

    def edit(Insecticide insecticideInstance) {
        respond insecticideInstance
    }

    @Transactional
    def update(Insecticide insecticideInstance) {
        if (insecticideInstance == null) {
            notFound()
            return
        }

        if (insecticideInstance.hasErrors()) {
            respond insecticideInstance.errors, view:'edit'
            return
        }

        insecticideInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Insecticide.label', default: 'Insecticide'), insecticideInstance.id])
                redirect insecticideInstance
            }
            '*'{ respond insecticideInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Insecticide insecticideInstance) {

        if (insecticideInstance == null) {
            notFound()
            return
        }

        insecticideInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Insecticide.label', default: 'Insecticide'), insecticideInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'insecticideInstance.label', default: 'Insecticide'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    def calculator(){
        def plant = Plant.get(Integer.parseInt(params.plantId))

    }
}
