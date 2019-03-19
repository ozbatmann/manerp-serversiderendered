package tr.com.manerp.business.sysref

import tr.com.manerp.base.domain.BaseDomain

class SysrefGender implements BaseDomain {

    String name
    String code

    static hasMany = []
    static belongsTo = []

    static constraints = {
        name nullable: false, blank: false, unique: false, maxSize: 10
        code nullable: false, blank: false, unique: true, maxSize: 3
    }

    static mapping = {
//        table name: "sysref_gender", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_SYSREF_GENDER']
    }

    static mappedBy = {
    }

}
