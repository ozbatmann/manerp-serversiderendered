package tr.com.manerp.business.main.vehicle

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TrailerController {

    TrailerService trailerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond trailerService.list(params), model:[trailerCount: trailerService.count()]
    }

    def show(String id) {
        respond trailerService.get(id)
    }

    def create() {
        respond new Trailer(params)
    }

    def save(Trailer trailer) {
        if (trailer == null) {
            notFound()
            return
        }

        try {
            trailerService.save(trailer)
        } catch (ValidationException e) {
            respond trailer.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trailer.label', default: 'Trailer'), trailer.id])
                redirect trailer
            }
            '*' { respond trailer, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond trailerService.get(id)
    }

    def update(Trailer trailer) {
        if (trailer == null) {
            notFound()
            return
        }

        try {
            trailerService.save(trailer)
        } catch (ValidationException e) {
            respond trailer.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'trailer.label', default: 'Trailer'), trailer.id])
                redirect trailer
            }
            '*'{ respond trailer, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        trailerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'trailer.label', default: 'Trailer'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trailer.label', default: 'Trailer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
