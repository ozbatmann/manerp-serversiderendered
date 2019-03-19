package tr.com.manerp.auth

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysCompanyController {

    SysCompanyService sysCompanyService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysCompanyService.list(params), model:[sysCompanyCount: sysCompanyService.count()]
    }

    def show(String id) {
        respond sysCompanyService.get(id)
    }

    def create() {
        respond new SysCompany(params)
    }

    def save(SysCompany sysCompany) {
        if (sysCompany == null) {
            notFound()
            return
        }

        try {
            sysCompanyService.save(sysCompany)
        } catch (ValidationException e) {
            respond sysCompany.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysCompany.label', default: 'SysCompany'), sysCompany.id])
                redirect sysCompany
            }
            '*' { respond sysCompany, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysCompanyService.get(id)
    }

    def update(SysCompany sysCompany) {
        if (sysCompany == null) {
            notFound()
            return
        }

        try {
            sysCompanyService.save(sysCompany)
        } catch (ValidationException e) {
            respond sysCompany.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysCompany.label', default: 'SysCompany'), sysCompany.id])
                redirect sysCompany
            }
            '*'{ respond sysCompany, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysCompanyService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysCompany.label', default: 'SysCompany'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysCompany.label', default: 'SysCompany'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
