package tr.com.manerp.business.main.resource

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StaffController {

    StaffService staffService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond staffService.list(params), model:[staffCount: staffService.count()]
    }

    def show(String id) {
        respond staffService.get(id)
    }

    def create() {
        respond new Staff(params)
    }

    def save(Staff staff) {
        if (staff == null) {
            notFound()
            return
        }

        try {
            staffService.save(staff)
        } catch (ValidationException e) {
            respond staff.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'staff.label', default: 'Staff'), staff.id])
                redirect staff
            }
            '*' { respond staff, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond staffService.get(id)
    }

    def update(Staff staff) {
        if (staff == null) {
            notFound()
            return
        }

        try {
            staffService.save(staff)
        } catch (ValidationException e) {
            respond staff.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'staff.label', default: 'Staff'), staff.id])
                redirect staff
            }
            '*'{ respond staff, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        staffService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'staff.label', default: 'Staff'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'staff.label', default: 'Staff'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
