package tr.com.manerp.business.main.resource

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StaffDocumentController {

    StaffDocumentService staffDocumentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond staffDocumentService.list(params), model:[staffDocumentCount: staffDocumentService.count()]
    }

    def show(String id) {
        respond staffDocumentService.get(id)
    }

    def create() {
        respond new StaffDocument(params)
    }

    def save(StaffDocument staffDocument) {
        if (staffDocument == null) {
            notFound()
            return
        }

        try {
            staffDocumentService.save(staffDocument)
        } catch (ValidationException e) {
            respond staffDocument.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'staffDocument.label', default: 'StaffDocument'), staffDocument.id])
                redirect staffDocument
            }
            '*' { respond staffDocument, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond staffDocumentService.get(id)
    }

    def update(StaffDocument staffDocument) {
        if (staffDocument == null) {
            notFound()
            return
        }

        try {
            staffDocumentService.save(staffDocument)
        } catch (ValidationException e) {
            respond staffDocument.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'staffDocument.label', default: 'StaffDocument'), staffDocument.id])
                redirect staffDocument
            }
            '*'{ respond staffDocument, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        staffDocumentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'staffDocument.label', default: 'StaffDocument'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'staffDocument.label', default: 'StaffDocument'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
