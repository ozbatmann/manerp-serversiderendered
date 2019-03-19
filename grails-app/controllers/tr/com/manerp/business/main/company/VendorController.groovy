package tr.com.manerp.business.main.company

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VendorController {

    VendorService vendorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorService.list(params), model:[vendorCount: vendorService.count()]
    }

    def show(String id) {
        respond vendorService.get(id)
    }

    def create() {
        respond new Vendor(params)
    }

    def save(Vendor vendor) {
        if (vendor == null) {
            notFound()
            return
        }

        try {
            vendorService.save(vendor)
        } catch (ValidationException e) {
            respond vendor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendor.label', default: 'Vendor'), vendor.id])
                redirect vendor
            }
            '*' { respond vendor, [status: CREATED] }
        }
    }

    def edit(String id) {
        respond vendorService.get(id)
    }

    def update(Vendor vendor) {
        if (vendor == null) {
            notFound()
            return
        }

        try {
            vendorService.save(vendor)
        } catch (ValidationException e) {
            respond vendor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendor.label', default: 'Vendor'), vendor.id])
                redirect vendor
            }
            '*'{ respond vendor, [status: OK] }
        }
    }

    def delete(String id) {
        if (id == null) {
            notFound()
            return
        }

        vendorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendor.label', default: 'Vendor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendor.label', default: 'Vendor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
