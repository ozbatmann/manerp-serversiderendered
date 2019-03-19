package tr.com.manerp.business.main.vehicle

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ArventoDeviceController {

    ArventoDeviceService arventoDeviceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond arventoDeviceService.list(params), model:[arventoDeviceCount: arventoDeviceService.count()]
    }

    def show(String id) {
        respond arventoDeviceService.get(id)
    }

    def create() {
        respond new ArventoDevice(params)
    }

    def save(ArventoDevice arventoDevice) {
        if (arventoDevice == null) {
            notFound()
            return
        }

        try {
            arventoDeviceService.save(arventoDevice)
        } catch (ValidationException e) {
            respond arventoDevice.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'arventoDevice.label', default: 'ArventoDevice'), arventoDevice.id])
                redirect arventoDevice
            }
            '*' { respond arventoDevice, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond arventoDeviceService.get(id)
    }

    def update(ArventoDevice arventoDevice) {
        if (arventoDevice == null) {
            notFound()
            return
        }

        try {
            arventoDeviceService.save(arventoDevice)
        } catch (ValidationException e) {
            respond arventoDevice.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'arventoDevice.label', default: 'ArventoDevice'), arventoDevice.id])
                redirect arventoDevice
            }
            '*'{ respond arventoDevice, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        arventoDeviceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'arventoDevice.label', default: 'ArventoDevice'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'arventoDevice.label', default: 'ArventoDevice'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
