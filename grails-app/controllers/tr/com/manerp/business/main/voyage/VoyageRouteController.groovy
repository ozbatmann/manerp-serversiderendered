package tr.com.manerp.business.main.voyage

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VoyageRouteController {

    VoyageRouteService voyageRouteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond voyageRouteService.list(params), model:[voyageRouteCount: voyageRouteService.count()]
    }

    def show(String id) {
        respond voyageRouteService.get(id)
    }

    def create() {
        respond new VoyageRoute(params)
    }

    def save(VoyageRoute voyageRoute) {
        if (voyageRoute == null) {
            notFound()
            return
        }

        try {
            voyageRouteService.save(voyageRoute)
        } catch (ValidationException e) {
            respond voyageRoute.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'voyageRoute.label', default: 'VoyageRoute'), voyageRoute.id])
                redirect voyageRoute
            }
            '*' { respond voyageRoute, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond voyageRouteService.get(id)
    }

    def update(VoyageRoute voyageRoute) {
        if (voyageRoute == null) {
            notFound()
            return
        }

        try {
            voyageRouteService.save(voyageRoute)
        } catch (ValidationException e) {
            respond voyageRoute.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'voyageRoute.label', default: 'VoyageRoute'), voyageRoute.id])
                redirect voyageRoute
            }
            '*'{ respond voyageRoute, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        voyageRouteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'voyageRoute.label', default: 'VoyageRoute'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'voyageRoute.label', default: 'VoyageRoute'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
