package tr.com.manerp.business.main.company

import tr.com.manerp.auth.SysCompany
import tr.com.manerp.base.domain.BaseDomain
import tr.com.manerp.business.sysref.SysrefCity
import tr.com.manerp.business.sysref.SysrefCountry
import tr.com.manerp.business.sysref.SysrefDistrict

class Vendor implements BaseDomain {

    static auditable = true

    Company company
    SysCompany sysCompany
    String title
    SysrefCity sysrefCity
    SysrefCountry sysrefCountry
    SysrefDistrict sysrefDistrict
    String address

    static constraints = {
        sysCompany nullable: false, unique: false
        sysrefCountry nullable: true, unique: false
        sysrefCity nullable: true, unique: false
        sysrefDistrict nullable: true, unique: false
        company nullable: false, unique: false
        title nullable: true, blank: true, unique: ['sysCompany'], maxSize: 150
        address nullable: true, blank: true, unique: false, maxSize: 500
    }

    static mapping = {
//        table name: "vendor", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_VENDOR']
    }


}
