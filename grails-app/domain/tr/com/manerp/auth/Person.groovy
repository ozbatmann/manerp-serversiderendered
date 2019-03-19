package tr.com.manerp.auth

import grails.util.Holders
import tr.com.manerp.base.domain.BaseDomain
import tr.com.manerp.business.sysref.SysrefGender

class Person implements BaseDomain {

    static auditable = true

    String name
    String lastName
    String email
    SysrefGender sysrefGender
    Long tcIdNumber
    Boolean isStaff
    byte[] photo
    String photoName
    String photoMimeType

    static hasMany = []
    static belongsTo = []

    static constraints = {
        photo shared: "optional", unique: false, maxSize: Holders.config.manerp.postgresql.maxByteSize
        photoName shared: "optional", unique: false
        photoMimeType shared: "optional", unique: false
        name shared: "necessary", unique: false
        lastName shared: "necessary", unique: false
        email shared: "necessary", email: true, unique: true
        sysrefGender nullable: true, unique: false
        tcIdNumber nullable: false, unique: false
        isStaff nullable: false, unique: false
    }

    static mapping = {
//        table name: "person", schema: "auth"
//        id generator: 'sequence', params: [sequence: 'auth.SEQ_PERSON']
    }

    static mappedBy = {
    }


}
