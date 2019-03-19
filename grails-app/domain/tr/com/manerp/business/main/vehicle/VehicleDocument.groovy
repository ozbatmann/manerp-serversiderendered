package tr.com.manerp.business.main.vehicle

import grails.databinding.BindingFormat
import tr.com.manerp.base.domain.BaseDomain

class VehicleDocument implements BaseDomain {

    static auditable = true

    Vehicle vehicle
    byte[] document
    String documentName
    String documentMimeType

    static constraints = {
        vehicle nullable: false, unique: false
        document nullable: false, unique: false
        documentName nullable: false, blank: false, unique: false
        documentMimeType nullable: false, blank: false, unique: false
    }

    static mapping = {
//        table name: "vehicle_document", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_VEHICLE_DOCUMENT']
    }

    def beforeValidate() {
        documentName = documentName?.trim()
        documentMimeType = documentMimeType?.trim()
    }

}
