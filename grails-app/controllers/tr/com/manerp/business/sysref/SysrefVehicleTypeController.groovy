package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefVehicleTypeController {

    SysrefVehicleTypeService sysrefVehicleTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefVehicleTypeService.list(params), model:[sysrefVehicleTypeCount: sysrefVehicleTypeService.count()]
    }

    def show(String id) {
        respond sysrefVehicleTypeService.get(id)
    }

    def create() {
        respond new SysrefVehicleType(params)
    }

    def save(SysrefVehicleType sysrefVehicleType) {
        if (sysrefVehicleType == null) {
            notFound()
            return
        }

        try {
            sysrefVehicleTypeService.save(sysrefVehicleType)
        } catch (ValidationException e) {
            respond sysrefVehicleType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefVehicleType.label', default: 'SysrefVehicleType'), sysrefVehicleType.id])
                redirect sysrefVehicleType
            }
            '*' { respond sysrefVehicleType, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefVehicleTypeService.get(id)
    }

    def update(SysrefVehicleType sysrefVehicleType) {
        if (sysrefVehicleType == null) {
            notFound()
            return
        }

        try {
            sysrefVehicleTypeService.save(sysrefVehicleType)
        } catch (ValidationException e) {
            respond sysrefVehicleType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefVehicleType.label', default: 'SysrefVehicleType'), sysrefVehicleType.id])
                redirect sysrefVehicleType
            }
            '*'{ respond sysrefVehicleType, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefVehicleTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefVehicleType.label', default: 'SysrefVehicleType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefVehicleType.label', default: 'SysrefVehicleType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
