package tr.com.manerp.business.main.vehicle

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VehicleDocumentController {

    VehicleDocumentService vehicleDocumentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vehicleDocumentService.list(params), model:[vehicleDocumentCount: vehicleDocumentService.count()]
    }

    def show(String id) {
        respond vehicleDocumentService.get(id)
    }

    def create() {
        respond new VehicleDocument(params)
    }

    def save(VehicleDocument vehicleDocument) {
        if (vehicleDocument == null) {
            notFound()
            return
        }

        try {
            vehicleDocumentService.save(vehicleDocument)
        } catch (ValidationException e) {
            respond vehicleDocument.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vehicleDocument.label', default: 'VehicleDocument'), vehicleDocument.id])
                redirect vehicleDocument
            }
            '*' { respond vehicleDocument, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond vehicleDocumentService.get(id)
    }

    def update(VehicleDocument vehicleDocument) {
        if (vehicleDocument == null) {
            notFound()
            return
        }

        try {
            vehicleDocumentService.save(vehicleDocument)
        } catch (ValidationException e) {
            respond vehicleDocument.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vehicleDocument.label', default: 'VehicleDocument'), vehicleDocument.id])
                redirect vehicleDocument
            }
            '*'{ respond vehicleDocument, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        vehicleDocumentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vehicleDocument.label', default: 'VehicleDocument'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicleDocument.label', default: 'VehicleDocument'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
