package tr.com.manerp.business.main.voyage

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VoyageController {

    VoyageService voyageService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond voyageService.list(params), model:[voyageCount: voyageService.count()]
    }

    def show(String id) {
        respond voyageService.get(id)
    }

    def create() {
        respond new Voyage(params)
    }

    def save(Voyage voyage) {
        if (voyage == null) {
            notFound()
            return
        }

        try {
            voyageService.save(voyage)
        } catch (ValidationException e) {
            respond voyage.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'voyage.label', default: 'Voyage'), voyage.id])
                redirect voyage
            }
            '*' { respond voyage, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond voyageService.get(id)
    }

    def update(Voyage voyage) {
        if (voyage == null) {
            notFound()
            return
        }

        try {
            voyageService.save(voyage)
        } catch (ValidationException e) {
            respond voyage.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'voyage.label', default: 'Voyage'), voyage.id])
                redirect voyage
            }
            '*'{ respond voyage, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        voyageService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'voyage.label', default: 'Voyage'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'voyage.label', default: 'Voyage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
