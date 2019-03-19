package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefVehicleOwnerController {

    SysrefVehicleOwnerService sysrefVehicleOwnerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefVehicleOwnerService.list(params), model:[sysrefVehicleOwnerCount: sysrefVehicleOwnerService.count()]
    }

    def show(String id) {
        respond sysrefVehicleOwnerService.get(id)
    }

    def create() {
        respond new SysrefVehicleOwner(params)
    }

    def save(SysrefVehicleOwner sysrefVehicleOwner) {
        if (sysrefVehicleOwner == null) {
            notFound()
            return
        }

        try {
            sysrefVehicleOwnerService.save(sysrefVehicleOwner)
        } catch (ValidationException e) {
            respond sysrefVehicleOwner.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefVehicleOwner.label', default: 'SysrefVehicleOwner'), sysrefVehicleOwner.id])
                redirect sysrefVehicleOwner
            }
            '*' { respond sysrefVehicleOwner, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefVehicleOwnerService.get(id)
    }

    def update(SysrefVehicleOwner sysrefVehicleOwner) {
        if (sysrefVehicleOwner == null) {
            notFound()
            return
        }

        try {
            sysrefVehicleOwnerService.save(sysrefVehicleOwner)
        } catch (ValidationException e) {
            respond sysrefVehicleOwner.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefVehicleOwner.label', default: 'SysrefVehicleOwner'), sysrefVehicleOwner.id])
                redirect sysrefVehicleOwner
            }
            '*'{ respond sysrefVehicleOwner, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefVehicleOwnerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefVehicleOwner.label', default: 'SysrefVehicleOwner'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefVehicleOwner.label', default: 'SysrefVehicleOwner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
