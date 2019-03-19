package tr.com.manerp.business.ref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RefWorkingAreaController {

    RefWorkingAreaService refWorkingAreaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond refWorkingAreaService.list(params), model:[refWorkingAreaCount: refWorkingAreaService.count()]
    }

    def show(String id) {
        respond refWorkingAreaService.get(id)
    }

    def create() {
        respond new RefWorkingArea(params)
    }

    def save(RefWorkingArea refWorkingArea) {
        if (refWorkingArea == null) {
            notFound()
            return
        }

        try {
            refWorkingAreaService.save(refWorkingArea)
        } catch (ValidationException e) {
            respond refWorkingArea.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'refWorkingArea.label', default: 'RefWorkingArea'), refWorkingArea.id])
                redirect refWorkingArea
            }
            '*' { respond refWorkingArea, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond refWorkingAreaService.get(id)
    }

    def update(RefWorkingArea refWorkingArea) {
        if (refWorkingArea == null) {
            notFound()
            return
        }

        try {
            refWorkingAreaService.save(refWorkingArea)
        } catch (ValidationException e) {
            respond refWorkingArea.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'refWorkingArea.label', default: 'RefWorkingArea'), refWorkingArea.id])
                redirect refWorkingArea
            }
            '*'{ respond refWorkingArea, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        refWorkingAreaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'refWorkingArea.label', default: 'RefWorkingArea'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'refWorkingArea.label', default: 'RefWorkingArea'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
