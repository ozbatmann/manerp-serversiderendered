package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefCompanyTypeController {

    SysrefCompanyTypeService sysrefCompanyTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefCompanyTypeService.list(params), model:[sysrefCompanyTypeCount: sysrefCompanyTypeService.count()]
    }

    def show(String id) {
        respond sysrefCompanyTypeService.get(id)
    }

    def create() {
        respond new SysrefCompanyType(params)
    }

    def save(SysrefCompanyType sysrefCompanyType) {
        if (sysrefCompanyType == null) {
            notFound()
            return
        }

        try {
            sysrefCompanyTypeService.save(sysrefCompanyType)
        } catch (ValidationException e) {
            respond sysrefCompanyType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefCompanyType.label', default: 'SysrefCompanyType'), sysrefCompanyType.id])
                redirect sysrefCompanyType
            }
            '*' { respond sysrefCompanyType, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefCompanyTypeService.get(id)
    }

    def update(SysrefCompanyType sysrefCompanyType) {
        if (sysrefCompanyType == null) {
            notFound()
            return
        }

        try {
            sysrefCompanyTypeService.save(sysrefCompanyType)
        } catch (ValidationException e) {
            respond sysrefCompanyType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefCompanyType.label', default: 'SysrefCompanyType'), sysrefCompanyType.id])
                redirect sysrefCompanyType
            }
            '*'{ respond sysrefCompanyType, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefCompanyTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefCompanyType.label', default: 'SysrefCompanyType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefCompanyType.label', default: 'SysrefCompanyType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
