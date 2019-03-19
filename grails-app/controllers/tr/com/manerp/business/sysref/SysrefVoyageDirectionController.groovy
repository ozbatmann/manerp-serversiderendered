package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefVoyageDirectionController {

    SysrefVoyageDirectionService sysrefVoyageDirectionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefVoyageDirectionService.list(params), model:[sysrefVoyageDirectionCount: sysrefVoyageDirectionService.count()]
    }

    def show(String id) {
        respond sysrefVoyageDirectionService.get(id)
    }

    def create() {
        respond new SysrefVoyageDirection(params)
    }

    def save(SysrefVoyageDirection sysrefVoyageDirection) {
        if (sysrefVoyageDirection == null) {
            notFound()
            return
        }

        try {
            sysrefVoyageDirectionService.save(sysrefVoyageDirection)
        } catch (ValidationException e) {
            respond sysrefVoyageDirection.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefVoyageDirection.label', default: 'SysrefVoyageDirection'), sysrefVoyageDirection.id])
                redirect sysrefVoyageDirection
            }
            '*' { respond sysrefVoyageDirection, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefVoyageDirectionService.get(id)
    }

    def update(SysrefVoyageDirection sysrefVoyageDirection) {
        if (sysrefVoyageDirection == null) {
            notFound()
            return
        }

        try {
            sysrefVoyageDirectionService.save(sysrefVoyageDirection)
        } catch (ValidationException e) {
            respond sysrefVoyageDirection.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefVoyageDirection.label', default: 'SysrefVoyageDirection'), sysrefVoyageDirection.id])
                redirect sysrefVoyageDirection
            }
            '*'{ respond sysrefVoyageDirection, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefVoyageDirectionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefVoyageDirection.label', default: 'SysrefVoyageDirection'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefVoyageDirection.label', default: 'SysrefVoyageDirection'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
