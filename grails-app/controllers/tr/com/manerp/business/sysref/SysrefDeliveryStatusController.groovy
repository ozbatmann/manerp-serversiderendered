package tr.com.manerp.business.sysref

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SysrefDeliveryStatusController {

    SysrefDeliveryStatusService sysrefDeliveryStatusService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sysrefDeliveryStatusService.list(params), model:[sysrefDeliveryStatusCount: sysrefDeliveryStatusService.count()]
    }

    def show(String id) {
        respond sysrefDeliveryStatusService.get(id)
    }

    def create() {
        respond new SysrefDeliveryStatus(params)
    }

    def save(SysrefDeliveryStatus sysrefDeliveryStatus) {
        if (sysrefDeliveryStatus == null) {
            notFound()
            return
        }

        try {
            sysrefDeliveryStatusService.save(sysrefDeliveryStatus)
        } catch (ValidationException e) {
            respond sysrefDeliveryStatus.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sysrefDeliveryStatus.label', default: 'SysrefDeliveryStatus'), sysrefDeliveryStatus.id])
                redirect sysrefDeliveryStatus
            }
            '*' { respond sysrefDeliveryStatus, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond sysrefDeliveryStatusService.get(id)
    }

    def update(SysrefDeliveryStatus sysrefDeliveryStatus) {
        if (sysrefDeliveryStatus == null) {
            notFound()
            return
        }

        try {
            sysrefDeliveryStatusService.save(sysrefDeliveryStatus)
        } catch (ValidationException e) {
            respond sysrefDeliveryStatus.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sysrefDeliveryStatus.label', default: 'SysrefDeliveryStatus'), sysrefDeliveryStatus.id])
                redirect sysrefDeliveryStatus
            }
            '*'{ respond sysrefDeliveryStatus, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        sysrefDeliveryStatusService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sysrefDeliveryStatus.label', default: 'SysrefDeliveryStatus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sysrefDeliveryStatus.label', default: 'SysrefDeliveryStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
