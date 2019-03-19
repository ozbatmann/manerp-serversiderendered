package tr.com.manerp.business.main.vehicle

import tr.com.manerp.auth.SysCompany
import tr.com.manerp.base.domain.BaseDomain

class Dorset implements BaseDomain {

    static auditable = true

    String code
    SysCompany sysCompany
    String plateNumber
    String name

    static constraints = {
        code nullable: true, blank: true, unique: ['sysCompany'], maxSize: 11
        sysCompany nullable: false, unique: false
        plateNumber nullable: false, blank: false, unique: false
        name nullable: true, blank: true, unique: false, maxSize: 50
    }

    static mapping = {
//        table name: "dorset", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_DORSET']
    }

    def beforeValidate() {
        name = name?.trim()
    }

}
