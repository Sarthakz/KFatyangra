package kfatyangra


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FoodController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Food.list(params), model: [foodInstanceCount: Food.count()]
    }

    def show(Food foodInstance) {
        respond foodInstance
    }

    def create() {
        respond new Food(params)
    }

    @Transactional
    def save(Food foodInstance) {
        if (foodInstance == null) {
            notFound()
            return
        }

        if (foodInstance.hasErrors()) {
            respond foodInstance.errors, view: 'create'
            return
        }

        foodInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'foodInstance.label', default: 'Food'), foodInstance.id])
                redirect foodInstance
            }
            '*' { respond foodInstance, [status: CREATED] }
        }
    }

    def edit(Food foodInstance) {
        respond foodInstance
    }

    @Transactional
    def update(Food foodInstance) {
        if (foodInstance == null) {
            notFound()
            return
        }

        if (foodInstance.hasErrors()) {
            respond foodInstance.errors, view: 'edit'
            return
        }

        foodInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Food.label', default: 'Food'), foodInstance.id])
                redirect foodInstance
            }
            '*' { respond foodInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Food foodInstance) {

        if (foodInstance == null) {
            notFound()
            return
        }

        foodInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Food.label', default: 'Food'), foodInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'foodInstance.label', default: 'Food'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
