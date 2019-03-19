package tr.com.manerp.business.main.company

import tr.com.manerp.auth.SysCompany
import tr.com.manerp.base.domain.BaseDomain
import tr.com.manerp.business.main.order.Order
import tr.com.manerp.business.main.resource.Staff
import tr.com.manerp.business.main.voyage.Voyage
import tr.com.manerp.business.ref.RefCompanySector
import tr.com.manerp.business.sysref.SysrefCity
import tr.com.manerp.business.sysref.SysrefCountry
import tr.com.manerp.business.sysref.SysrefDistrict
import tr.com.manerp.business.sysref.SysrefNaceCode

class Company implements BaseDomain {

    static auditable = true

    SysCompany sysCompany
    String name
    String title
    SysrefCountry sysrefCountry
    SysrefCity sysrefCity
    SysrefDistrict sysrefDistrict
    String address
    String phone
    String phone2
    String fax
    String gsm
    String webAddress
    String email
    RefCompanySector refCompanySector
    Staff customerRepresentative
    Integer numberOfStaff
    String employerRegistrationNo
    String tradeRegistrationNo
    String taxOffice
    String taxNumber
    SysrefNaceCode sysrefNaceCode

    static hasMany = [
            vendors: Vendor,            // Company bayileri
            orders : Order,
            voyages: Voyage
    ]

    static constraints = {
        sysCompany nullable: false, unique: false
        name nullable: false, blank: false, unique: false, maxSize: 50
        title nullable: true, blank: true, unique: ['sysCompany'], maxSize: 50
        sysrefCountry nullable: true, unique: false
        sysrefCity nullable: true, unique: false
        sysrefDistrict nullable: true, unique: false
        address nullable: false, blank: false, unique: false, maxSize: 500
        phone nullable: false, blank: false, unique: false, maxSize: 20
        phone2 nullable: true, blank: true, unique: false, maxSize: 20
        fax nullable: true, blank: true, unique: false, maxSize: 20
        gsm nullable: true, blank: true, unique: false, maxSize: 20
        webAddress nullable: true, blank: true, unique: false, maxSize: 50
        email nullable: false, blank: false, unique: false, maxSize: 50
        refCompanySector nullable: true, unique: false
        customerRepresentative nullable: true, unique: false
        numberOfStaff nullable: true, unique: false
        employerRegistrationNo nullable: true, blank: true, unique: ['sysCompany'], maxSize: 30
        tradeRegistrationNo nullable: false, blank: false, unique: ['sysCompany'], maxSize: 30
        taxOffice nullable: true, blank: true, unique: false, maxSize: 255
        taxNumber nullable: true, blank: true, unique: ['sysCompany'], maxSize: 50
        sysrefNaceCode nullable: true, unique: false
    }

    static mapping = {
//        table name: "company", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_COMPANY']
        vendors cascade: 'all-delete-orphan'
        orders cascade: 'all-delete-orphan'
        voyages cascade: 'all-delete-orphan'
    }


}
