package tr.com.manerp.business.ref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RefCompanySectorController {

    RefCompanySectorService refCompanySectorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond refCompanySectorService.list(params), model:[refCompanySectorCount: refCompanySectorService.count()]
    }

    def show(String id) {
        respond refCompanySectorService.get(id)
    }

    def create() {
        respond new RefCompanySector(params)
    }

    def save(RefCompanySector refCompanySector) {
        if (refCompanySector == null) {
            notFound()
            return
        }

        try {
            refCompanySectorService.save(refCompanySector)
        } catch (ValidationException e) {
            respond refCompanySector.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'refCompanySector.label', default: 'RefCompanySector'), refCompanySector.id])
                redirect refCompanySector
            }
            '*' { respond refCompanySector, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond refCompanySectorService.get(id)
    }

    def update(RefCompanySector refCompanySector) {
        if (refCompanySector == null) {
            notFound()
            return
        }

        try {
            refCompanySectorService.save(refCompanySector)
        } catch (ValidationException e) {
            respond refCompanySector.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'refCompanySector.label', default: 'RefCompanySector'), refCompanySector.id])
                redirect refCompanySector
            }
            '*'{ respond refCompanySector, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        refCompanySectorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'refCompanySector.label', default: 'RefCompanySector'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'refCompanySector.label', default: 'RefCompanySector'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
