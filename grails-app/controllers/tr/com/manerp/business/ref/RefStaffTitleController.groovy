package tr.com.manerp.business.ref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RefStaffTitleController {

    RefStaffTitleService refStaffTitleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond refStaffTitleService.list(params), model:[refStaffTitleCount: refStaffTitleService.count()]
    }

    def show(String id) {
        respond refStaffTitleService.get(id)
    }

    def create() {
        respond new RefStaffTitle(params)
    }

    def save(RefStaffTitle refStaffTitle) {
        if (refStaffTitle == null) {
            notFound()
            return
        }

        try {
            refStaffTitleService.save(refStaffTitle)
        } catch (ValidationException e) {
            respond refStaffTitle.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'refStaffTitle.label', default: 'RefStaffTitle'), refStaffTitle.id])
                redirect refStaffTitle
            }
            '*' { respond refStaffTitle, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond refStaffTitleService.get(id)
    }

    def update(RefStaffTitle refStaffTitle) {
        if (refStaffTitle == null) {
            notFound()
            return
        }

        try {
            refStaffTitleService.save(refStaffTitle)
        } catch (ValidationException e) {
            respond refStaffTitle.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'refStaffTitle.label', default: 'RefStaffTitle'), refStaffTitle.id])
                redirect refStaffTitle
            }
            '*'{ respond refStaffTitle, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        refStaffTitleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'refStaffTitle.label', default: 'RefStaffTitle'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'refStaffTitle.label', default: 'RefStaffTitle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
