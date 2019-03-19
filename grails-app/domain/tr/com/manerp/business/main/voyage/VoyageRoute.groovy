package tr.com.manerp.business.main.voyage

import tr.com.manerp.base.domain.BaseDomain

class VoyageRoute implements BaseDomain {

    static auditable = true

    Location location
    Voyage voyage

    static constraints = {
        location nullable: false, unique: false
        voyage nullable: false, unique: false
    }

    static mapping = {
//        table name: "voyage_route", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_VOYAGE_ROUTE']
    }

}
