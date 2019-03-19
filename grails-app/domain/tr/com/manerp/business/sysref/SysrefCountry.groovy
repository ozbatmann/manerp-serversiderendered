package tr.com.manerp.business.sysref

import tr.com.manerp.base.domain.BaseDomain

class SysrefCountry implements BaseDomain {

    String name
    String code

    static hasMany = []
    static belongsTo = []

    static constraints = {
        name nullable: false, blank: false, unique: false, maxSize: 100
        code nullable: false, blank: false, unique: true, maxSize: 10
    }

    static mapping = {
//        table name: "sysref_country", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_SYSREF_COUNTRY']
    }

    static mappedBy = {
    }

}
