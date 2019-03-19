package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefTransportationTypeController {

    SysrefTransportationTypeService sysrefTransportationTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefTransportationTypeService.list(params), model:[sysrefTransportationTypeCount: sysrefTransportationTypeService.count()]
    }

    def show(String id) {
        respond sysrefTransportationTypeService.get(id)
    }

    def create() {
        respond new SysrefTransportationType(params)
    }

    def save(SysrefTransportationType sysrefTransportationType) {
        if (sysrefTransportationType == null) {
            notFound()
            return
        }

        try {
            sysrefTransportationTypeService.save(sysrefTransportationType)
        } catch (ValidationException e) {
            respond sysrefTransportationType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefTransportationType.label', default: 'SysrefTransportationType'), sysrefTransportationType.id])
                redirect sysrefTransportationType
            }
            '*' { respond sysrefTransportationType, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefTransportationTypeService.get(id)
    }

    def update(SysrefTransportationType sysrefTransportationType) {
        if (sysrefTransportationType == null) {
            notFound()
            return
        }

        try {
            sysrefTransportationTypeService.save(sysrefTransportationType)
        } catch (ValidationException e) {
            respond sysrefTransportationType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefTransportationType.label', default: 'SysrefTransportationType'), sysrefTransportationType.id])
                redirect sysrefTransportationType
            }
            '*'{ respond sysrefTransportationType, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefTransportationTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefTransportationType.label', default: 'SysrefTransportationType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefTransportationType.label', default: 'SysrefTransportationType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
