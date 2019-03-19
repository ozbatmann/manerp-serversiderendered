package tr.com.manerp.business.main.voyage

import tr.com.manerp.base.domain.BaseDomain

class Location implements BaseDomain {

    static auditable = true

    String locationName
    String latitude
    String longitude

    static constraints = {
        locationName nullable: false, blank: false, unique: false, maxSize: 100
        latitude nullable: true, blank: true, unique: false, maxSize: 100
        longitude nullable: true, blank: true, unique: false
    }

    static mapping = {
//        table name: "location", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_LOCATION']
    }

}
