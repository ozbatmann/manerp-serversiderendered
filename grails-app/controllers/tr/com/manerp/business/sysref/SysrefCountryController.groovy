package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefCountryController {

    SysrefCountryService sysrefCountryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefCountryService.list(params), model:[sysrefCountryCount: sysrefCountryService.count()]
    }

    def show(String id) {
        respond sysrefCountryService.get(id)
    }

    def create() {
        respond new SysrefCountry(params)
    }

    def save(SysrefCountry sysrefCountry) {
        if (sysrefCountry == null) {
            notFound()
            return
        }

        try {
            sysrefCountryService.save(sysrefCountry)
        } catch (ValidationException e) {
            respond sysrefCountry.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefCountry.label', default: 'SysrefCountry'), sysrefCountry.id])
                redirect sysrefCountry
            }
            '*' { respond sysrefCountry, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefCountryService.get(id)
    }

    def update(SysrefCountry sysrefCountry) {
        if (sysrefCountry == null) {
            notFound()
            return
        }

        try {
            sysrefCountryService.save(sysrefCountry)
        } catch (ValidationException e) {
            respond sysrefCountry.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefCountry.label', default: 'SysrefCountry'), sysrefCountry.id])
                redirect sysrefCountry
            }
            '*'{ respond sysrefCountry, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefCountryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefCountry.label', default: 'SysrefCountry'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefCountry.label', default: 'SysrefCountry'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
