package tr.com.manerp.business.main.vehicle

import tr.com.manerp.auth.SysCompany
import tr.com.manerp.base.domain.BaseDomain

class ArventoDevice implements BaseDomain {

    static auditable = true

    String code
    SysCompany sysCompany
    String deviceId
    String name
    Vehicle vehicle
    Dorset dorset

    static constraints = {
        code nullable: true, blank: true, unique: ['sysCompany'], maxSize: 11
        sysCompany nullable: false, unique: false
        deviceId nullable: false, unique: false, maxSize: 100
        name nullable: true, blank: true, unique: false, maxSize: 50
        vehicle nullable: true, unique: false
        dorset nullable: true, unique: false
    }

    static mapping = {
//        table name: "arvento_device", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_ARVENTO_DEVICE']
    }

    def beforeValidate() {
        name = name?.trim()
    }

}
