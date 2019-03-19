package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefDrivingTypeController {

    SysrefDrivingTypeService sysrefDrivingTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefDrivingTypeService.list(params), model:[sysrefDrivingTypeCount: sysrefDrivingTypeService.count()]
    }

    def show(String id) {
        respond sysrefDrivingTypeService.get(id)
    }

    def create() {
        respond new SysrefDrivingType(params)
    }

    def save(SysrefDrivingType sysrefDrivingType) {
        if (sysrefDrivingType == null) {
            notFound()
            return
        }

        try {
            sysrefDrivingTypeService.save(sysrefDrivingType)
        } catch (ValidationException e) {
            respond sysrefDrivingType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefDrivingType.label', default: 'SysrefDrivingType'), sysrefDrivingType.id])
                redirect sysrefDrivingType
            }
            '*' { respond sysrefDrivingType, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefDrivingTypeService.get(id)
    }

    def update(SysrefDrivingType sysrefDrivingType) {
        if (sysrefDrivingType == null) {
            notFound()
            return
        }

        try {
            sysrefDrivingTypeService.save(sysrefDrivingType)
        } catch (ValidationException e) {
            respond sysrefDrivingType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefDrivingType.label', default: 'SysrefDrivingType'), sysrefDrivingType.id])
                redirect sysrefDrivingType
            }
            '*'{ respond sysrefDrivingType, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefDrivingTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefDrivingType.label', default: 'SysrefDrivingType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefDrivingType.label', default: 'SysrefDrivingType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
