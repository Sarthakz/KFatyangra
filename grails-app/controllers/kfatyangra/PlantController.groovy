package kfatyangra


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PlantController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Plant.list(params), model: [plantInstanceCount: Plant.count()]
    }

    def show(Plant plantInstance) {
        respond plantInstance
    }

    def create() {
        respond new Plant(params)
    }

    @Transactional
    def save(Plant plantInstance) {
        if (plantInstance == null) {
            notFound()
            return
        }

        if (plantInstance.hasErrors()) {
            respond plantInstance.errors, view: 'create'
            return
        }

        plantInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'plantInstance.label', default: 'Plant'), plantInstance.id])
                redirect plantInstance
            }
            '*' { respond plantInstance, [status: CREATED] }
        }
    }

    def edit(Plant plantInstance) {
        respond plantInstance
    }

    @Transactional
    def update(Plant plantInstance) {
        if (plantInstance == null) {
            notFound()
            return
        }

        if (plantInstance.hasErrors()) {
            respond plantInstance.errors, view: 'edit'
            return
        }

        plantInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Plant.label', default: 'Plant'), plantInstance.id])
                redirect plantInstance
            }
            '*' { respond plantInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Plant plantInstance) {

        if (plantInstance == null) {
            notFound()
            return
        }

        plantInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Plant.label', default: 'Plant'), plantInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'plantInstance.label', default: 'Plant'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
