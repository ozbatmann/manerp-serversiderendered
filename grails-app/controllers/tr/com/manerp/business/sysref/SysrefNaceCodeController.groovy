package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefNaceCodeController {

    SysrefNaceCodeService sysrefNaceCodeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefNaceCodeService.list(params), model:[sysrefNaceCodeCount: sysrefNaceCodeService.count()]
    }

    def show(String id) {
        respond sysrefNaceCodeService.get(id)
    }

    def create() {
        respond new SysrefNaceCode(params)
    }

    def save(SysrefNaceCode sysrefNaceCode) {
        if (sysrefNaceCode == null) {
            notFound()
            return
        }

        try {
            sysrefNaceCodeService.save(sysrefNaceCode)
        } catch (ValidationException e) {
            respond sysrefNaceCode.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefNaceCode.label', default: 'SysrefNaceCode'), sysrefNaceCode.id])
                redirect sysrefNaceCode
            }
            '*' { respond sysrefNaceCode, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefNaceCodeService.get(id)
    }

    def update(SysrefNaceCode sysrefNaceCode) {
        if (sysrefNaceCode == null) {
            notFound()
            return
        }

        try {
            sysrefNaceCodeService.save(sysrefNaceCode)
        } catch (ValidationException e) {
            respond sysrefNaceCode.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefNaceCode.label', default: 'SysrefNaceCode'), sysrefNaceCode.id])
                redirect sysrefNaceCode
            }
            '*'{ respond sysrefNaceCode, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefNaceCodeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefNaceCode.label', default: 'SysrefNaceCode'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefNaceCode.label', default: 'SysrefNaceCode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
