package tr.com.manerp.business.ref

import tr.com.manerp.auth.SysCompany
import tr.com.manerp.base.domain.BaseDomain

class RefStaffTitle implements BaseDomain {

    static auditable = true

    SysCompany sysCompany
    String name
    String code
    String description

    static hasMany = []
    static belongsTo = []

    static constraints = {
        importFrom(RefCompanySector)
    }

    static mapping = {
//        table name: "ref_staff_class", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_REF_STAFF_CLASS']
    }

    static mappedBy = {
    }


}
