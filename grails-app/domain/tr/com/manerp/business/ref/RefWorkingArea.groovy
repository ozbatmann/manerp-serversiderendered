package tr.com.manerp.business.ref

import grails.databinding.BindingFormat
import tr.com.manerp.auth.SysCompany
import tr.com.manerp.base.domain.BaseDomain

class RefWorkingArea implements BaseDomain {

    static auditable = true

    SysCompany sysCompany
    String name
    String code
    String description

    static hasMany = []
    static belongsTo = []

    static constraints = {
        importFrom(RefStaffTitle)
    }

    static mapping = {
//        table name: "ref_working_area", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_REF_WORKING_AREA']
    }

    static mappedBy = {
    }


}
