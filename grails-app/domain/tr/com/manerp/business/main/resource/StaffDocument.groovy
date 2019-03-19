package tr.com.manerp.business.main.resource

import grails.databinding.BindingFormat
import tr.com.manerp.base.domain.BaseDomain

class StaffDocument implements BaseDomain {

    static auditable = true

    Staff staff
    byte[] document
    String documentName
    String documentMimeType

    static constraints = {
        staff nullable: false, unique: false
        document nullable: false, unique: false
        documentName nullable: false, blank: false, unique: false
        documentMimeType nullable: false, blank: false, unique: false
    }

    static mapping = {
//        table name: "staff_document", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_STAFF_DOCUMENT']
    }


}
