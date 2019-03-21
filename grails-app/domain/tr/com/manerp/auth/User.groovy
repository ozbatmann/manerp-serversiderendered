package tr.com.manerp.auth

import grails.util.Holders
import tr.com.manerp.base.domain.BaseDomain
import tr.com.manerp.common.Person

class User implements BaseDomain, Person {

    static auditable = true

    SysCompany sysCompany
    String username
    String passwordHash
    Long version
    Boolean accountExpired
    Boolean accountLocked
    Boolean passwordExpired
    String salt
    Boolean isDeletable

    static hasMany = []
    static belongsTo = []

    static constraints = {
        sysCompany nullable: false, unique: false
        username nullable: false, blank: false, unique: ['sysCompany'], maxSize: 50
        passwordHash nullable: false, blank: false, unique: false, maxSize: 255
        version nullable: true, unique: false
        accountExpired nullable: false, unique: false
        accountLocked nullable: false, unique: false
        active nullable: false, unique: false
        passwordExpired nullable: false, unique: false
        salt nullable: true, blank: true, unique: false
        isDeletable nullable: false, unique: false

        // Person constraints, these constraints shared with Staff class
        photo nullable: true, blank: true, unique: false, maxSize: Holders.config.manerp.postgresql.maxByteSize
        photoName nullable: true, blank: true, unique: false
        photoMimeType nullable: true, blank: true, unique: false
        firstName nullable: false, blank: false, unique: false, maxSize: 30
        middleName nullable: true, blank: true, unique: false, maxSize: 30
        lastName nullable: false, blank: false, unique: false, maxSize: 50
        email email: true, blank: false, nullable: false, unique: ['sysCompany']
        sysrefGender nullable: true, unique: false
        tcIdNumber nullable: false, unique: ['sysCompany']
        isStaff nullable: false, unique: false
        birthDate nullable: true, unique: false
        sysrefCountry nullable: true, unique: false
        sysrefCity nullable: true, unique: false
        sysrefDistrict nullable: true, unique: false
        address nullable: true, blank: true, unique: false, maxSize: 255
        homePhone nullable: true, blank: true, unique: false, maxSize: 15
        gsmNo nullable: false, blank: false, unique: false, maxSize: 15

    }

    static mapping = {
//        table name: "awc_user", schema: "auth"
//        id generator: 'sequence', params: [sequence: 'auth.SEQ_AWC_USER']
    }

    static mappedBy = {
    }

    def beforeValidate() {
        username = username?.trim()
    }

}
