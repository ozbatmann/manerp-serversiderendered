package tr.com.manerp.business.sysref

import tr.com.manerp.base.domain.BaseDomain

class SysrefNaceCode implements BaseDomain {

    String name
    String code

    static hasMany = []
    static belongsTo = []

    static constraints = {
        name nullable: false, blank: false, unique: false, maxSize: 50
        code nullable: false, blank: false, unique: true
    }

    static mapping = {
//        table name: "sysref_nace_code", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_SYSREF_NACE_CODE']
    }

    static mappedBy = {
    }

}
