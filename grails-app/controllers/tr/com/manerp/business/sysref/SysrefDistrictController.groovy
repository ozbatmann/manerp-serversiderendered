package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefDistrictController {

    SysrefDistrictService sysrefDistrictService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefDistrictService.list(params), model:[sysrefDistrictCount: sysrefDistrictService.count()]
    }

    def show(String id) {
        respond sysrefDistrictService.get(id)
    }

    def create() {
        respond new SysrefDistrict(params)
    }

    def save(SysrefDistrict sysrefDistrict) {
        if (sysrefDistrict == null) {
            notFound()
            return
        }

        try {
            sysrefDistrictService.save(sysrefDistrict)
        } catch (ValidationException e) {
            respond sysrefDistrict.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefDistrict.label', default: 'SysrefDistrict'), sysrefDistrict.id])
                redirect sysrefDistrict
            }
            '*' { respond sysrefDistrict, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefDistrictService.get(id)
    }

    def update(SysrefDistrict sysrefDistrict) {
        if (sysrefDistrict == null) {
            notFound()
            return
        }

        try {
            sysrefDistrictService.save(sysrefDistrict)
        } catch (ValidationException e) {
            respond sysrefDistrict.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefDistrict.label', default: 'SysrefDistrict'), sysrefDistrict.id])
                redirect sysrefDistrict
            }
            '*'{ respond sysrefDistrict, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefDistrictService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefDistrict.label', default: 'SysrefDistrict'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefDistrict.label', default: 'SysrefDistrict'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
