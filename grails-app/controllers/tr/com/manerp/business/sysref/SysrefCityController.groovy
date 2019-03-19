package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefCityController {

    SysrefCityService sysrefCityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefCityService.list(params), model:[sysrefCityCount: sysrefCityService.count()]
    }

    def show(String id) {
        respond sysrefCityService.get(id)
    }

    def create() {
        respond new SysrefCity(params)
    }

    def save(SysrefCity sysrefCity) {
        if (sysrefCity == null) {
            notFound()
            return
        }

        try {
            sysrefCityService.save(sysrefCity)
        } catch (ValidationException e) {
            respond sysrefCity.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefCity.label', default: 'SysrefCity'), sysrefCity.id])
                redirect sysrefCity
            }
            '*' { respond sysrefCity, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefCityService.get(id)
    }

    def update(SysrefCity sysrefCity) {
        if (sysrefCity == null) {
            notFound()
            return
        }

        try {
            sysrefCityService.save(sysrefCity)
        } catch (ValidationException e) {
            respond sysrefCity.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefCity.label', default: 'SysrefCity'), sysrefCity.id])
                redirect sysrefCity
            }
            '*'{ respond sysrefCity, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefCityService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefCity.label', default: 'SysrefCity'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefCity.label', default: 'SysrefCity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
