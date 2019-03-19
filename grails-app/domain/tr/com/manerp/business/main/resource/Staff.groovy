package tr.com.manerp.business.main.resource

import tr.com.manerp.auth.SysCompany
import tr.com.manerp.auth.User
import tr.com.manerp.base.domain.BaseDomain
import tr.com.manerp.business.ref.RefStaffTitle
import tr.com.manerp.business.sysref.SysrefCity
import tr.com.manerp.business.sysref.SysrefCountry
import tr.com.manerp.business.sysref.SysrefDistrict
import tr.com.manerp.business.sysref.SysrefDrivingType
import tr.com.manerp.business.sysref.SysrefStaffContractType
import tr.com.manerp.common.Person

class Staff implements BaseDomain, Person {

    static auditable = true

    String code
    SysCompany sysCompany
    User user
    RefStaffTitle refStaffTitle
    SysrefStaffContractType sysrefStaffContractType
    String drivingLicenseNumber
    Boolean hasFuelAdvance // yakit avansi var mi?
    SysrefDrivingType sysrefDrivingType

    static hasMany = [
        staffDocuments: StaffDocument
    ]
    static belongsTo = []

    static constraints = {

        importFrom(User)

        code nullable: true, blank: true, unique: ['sysCompany'], maxSize: 11
        user nullable: true, unique: false
        refStaffTitle nullable: false, unique: false
        sysrefStaffContractType nullable: true, unique: false
        drivingLicenseNumber nullable: true, unique: false, maxSize: 30
        hasFuelAdvance nullable: true, unique: false
        sysrefDrivingType nullable: true, unique: false
    }

    static mapping = {
//        table name: "staff", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_STAFF']
        staffDocuments cascade: 'all-delete-orphan'
    }

    static mappedBy = {
    }

}
