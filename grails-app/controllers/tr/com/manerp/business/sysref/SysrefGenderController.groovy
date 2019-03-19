package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefGenderController {

    SysrefGenderService sysrefGenderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefGenderService.list(params), model:[sysrefGenderCount: sysrefGenderService.count()]
    }

    def show(String id) {
        respond sysrefGenderService.get(id)
    }

    def create() {
        respond new SysrefGender(params)
    }

    def save(SysrefGender sysrefGender) {
        if (sysrefGender == null) {
            notFound()
            return
        }

        try {
            sysrefGenderService.save(sysrefGender)
        } catch (ValidationException e) {
            respond sysrefGender.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefGender.label', default: 'SysrefGender'), sysrefGender.id])
                redirect sysrefGender
            }
            '*' { respond sysrefGender, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefGenderService.get(id)
    }

    def update(SysrefGender sysrefGender) {
        if (sysrefGender == null) {
            notFound()
            return
        }

        try {
            sysrefGenderService.save(sysrefGender)
        } catch (ValidationException e) {
            respond sysrefGender.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefGender.label', default: 'SysrefGender'), sysrefGender.id])
                redirect sysrefGender
            }
            '*'{ respond sysrefGender, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefGenderService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefGender.label', default: 'SysrefGender'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefGender.label', default: 'SysrefGender'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
