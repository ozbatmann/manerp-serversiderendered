package tr.com.manerp.business.main.vehicle

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DorsetController {

    DorsetService dorsetService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dorsetService.list(params), model:[dorsetCount: dorsetService.count()]
    }

    def show(String id) {
        respond dorsetService.get(id)
    }

    def create() {
        respond new Dorset(params)
    }

    def save(Dorset dorset) {
        if (dorset == null) {
            notFound()
            return
        }

        try {
            dorsetService.save(dorset)
        } catch (ValidationException e) {
            respond dorset.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dorset.label', default: 'Dorset'), dorset.id])
                redirect dorset
            }
            '*' { respond dorset, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond dorsetService.get(id)
    }

    def update(Dorset dorset) {
        if (dorset == null) {
            notFound()
            return
        }

        try {
            dorsetService.save(dorset)
        } catch (ValidationException e) {
            respond dorset.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dorset.label', default: 'Dorset'), dorset.id])
                redirect dorset
            }
            '*'{ respond dorset, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        dorsetService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dorset.label', default: 'Dorset'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dorset.label', default: 'Dorset'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
