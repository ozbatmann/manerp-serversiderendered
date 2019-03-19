package tr.com.manerp.business.sysref

import tr.com.manerp.base.domain.BaseDomain


class SysrefDistrict implements BaseDomain {

    String name
    String code
    SysrefCity sysrefCity

    static hasMany = []
    static belongsTo = []

    static constraints = {
        name nullable: false, blank: false, unique: false, maxSize: 100
        code nullable: false, blank: false, unique: true, maxSize: 10
        sysrefCity nullable: false, unique: false
    }

    static mapping = {
//        table name: "sysref_city", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_SYSREF_CITY']
    }

    static mappedBy = {
    }

}
