package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefStaffContractTypeController {

    SysrefStaffContractTypeService sysrefStaffContractTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefStaffContractTypeService.list(params), model:[sysrefStaffContractTypeCount: sysrefStaffContractTypeService.count()]
    }

    def show(String id) {
        respond sysrefStaffContractTypeService.get(id)
    }

    def create() {
        respond new SysrefStaffContractType(params)
    }

    def save(SysrefStaffContractType sysrefStaffContractType) {
        if (sysrefStaffContractType == null) {
            notFound()
            return
        }

        try {
            sysrefStaffContractTypeService.save(sysrefStaffContractType)
        } catch (ValidationException e) {
            respond sysrefStaffContractType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefStaffContractType.label', default: 'SysrefStaffContractType'), sysrefStaffContractType.id])
                redirect sysrefStaffContractType
            }
            '*' { respond sysrefStaffContractType, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefStaffContractTypeService.get(id)
    }

    def update(SysrefStaffContractType sysrefStaffContractType) {
        if (sysrefStaffContractType == null) {
            notFound()
            return
        }

        try {
            sysrefStaffContractTypeService.save(sysrefStaffContractType)
        } catch (ValidationException e) {
            respond sysrefStaffContractType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefStaffContractType.label', default: 'SysrefStaffContractType'), sysrefStaffContractType.id])
                redirect sysrefStaffContractType
            }
            '*'{ respond sysrefStaffContractType, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefStaffContractTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefStaffContractType.label', default: 'SysrefStaffContractType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefStaffContractType.label', default: 'SysrefStaffContractType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
