package kfatyangra



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class InsecticideController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Item.list(params), model:[itemInstanceCount: Item.count()]
    }

    def show() {
        def itemInstance = Item.get(params.id as long)
        [itemInstance:itemInstance]
    }

    def create() {
        respond new Item(params)
    }

    @Transactional
    def save(Item itemInstance) {
        if (itemInstance == null) {
            notFound()
            return
        }

        if (itemInstance.hasErrors()) {
            respond itemInstance.errors, view:'create'
            return
        }

        itemInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itemInstance.label', default: 'Items'), itemInstance.id])
                redirect itemInstance
            }
            '*' { respond itemInstance, [status: CREATED] }
        }
    }

    def edit(Item itemInstance) {
        respond itemInstance
    }

    @Transactional
    def update(Item itemInstance) {
        if (itemInstance == null) {
            notFound()
            return
        }

        if (itemInstance.hasErrors()) {
            respond itemInstance.errors, view:'edit'
            return
        }

        itemInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Item.label', default: 'Item'), itemInstance.id])
                redirect itemInstance
            }
            '*'{ respond itemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Item itemInstance) {

        if (itemInstance == null) {
            notFound()
            return
        }

        itemInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Item.label', default: 'Insecticide'), itemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'Item.label', default: 'Insecticide'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    def calculator(){
        def plant = Food.get(Integer.parseInt(params.plantId))

    }
    @Transactional
    def rating(){
        def item = Item.findById(params.insecticideId as long)
        println item
        def userId = session.getAttribute('id');
        def user = Member.findById(userId as long)
        println user
        def isInsecticide = Rating.findByItemAndMember(item,user)
        if(isInsecticide){
            isInsecticide.rating = params.rating as long
            isInsecticide.save flush: true, failOnError: true
        }else{
            Rating rating = new Rating()
            rating.item = item
            rating.member = user
            rating.rating = params.rating as long
            rating.save flush: true, failOnError: true
        }
        redirect(controller: 'recommendation', action: 'index')
    }
}
