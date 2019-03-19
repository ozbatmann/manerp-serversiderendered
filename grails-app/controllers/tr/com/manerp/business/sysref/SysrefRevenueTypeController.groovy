package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefRevenueTypeController {

    SysrefRevenueTypeService sysrefRevenueTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefRevenueTypeService.list(params), model:[sysrefRevenueTypeCount: sysrefRevenueTypeService.count()]
    }

    def show(String id) {
        respond sysrefRevenueTypeService.get(id)
    }

    def create() {
        respond new SysrefRevenueType(params)
    }

    def save(SysrefRevenueType sysrefRevenueType) {
        if (sysrefRevenueType == null) {
            notFound()
            return
        }

        try {
            sysrefRevenueTypeService.save(sysrefRevenueType)
        } catch (ValidationException e) {
            respond sysrefRevenueType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefRevenueType.label', default: 'SysrefRevenueType'), sysrefRevenueType.id])
                redirect sysrefRevenueType
            }
            '*' { respond sysrefRevenueType, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefRevenueTypeService.get(id)
    }

    def update(SysrefRevenueType sysrefRevenueType) {
        if (sysrefRevenueType == null) {
            notFound()
            return
        }

        try {
            sysrefRevenueTypeService.save(sysrefRevenueType)
        } catch (ValidationException e) {
            respond sysrefRevenueType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefRevenueType.label', default: 'SysrefRevenueType'), sysrefRevenueType.id])
                redirect sysrefRevenueType
            }
            '*'{ respond sysrefRevenueType, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefRevenueTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefRevenueType.label', default: 'SysrefRevenueType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefRevenueType.label', default: 'SysrefRevenueType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
