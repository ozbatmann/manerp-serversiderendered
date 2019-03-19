package tr.com.manerp.business.main.order

import grails.databinding.BindingFormat
import tr.com.manerp.auth.SysCompany
import tr.com.manerp.base.domain.BaseDomain
import tr.com.manerp.business.main.company.Company
import tr.com.manerp.business.sysref.SysrefRevenueType

class Order implements BaseDomain {

    static auditable = true

    String code
    SysCompany sysCompany
    Company company
    String name
    @BindingFormat('dd/MM/yyyy hh:MM')
    Date orderDate
    String workOrderNo
    SysrefRevenueType sysrefRevenueType
    String billingNo

    static constraints = {
        code nullable: true, blank: true, unique: ['sysCompany'], maxSize: 11
        sysCompany nullable: false, unique: false
        company nullable: false, unique: false
        name nullable: false, blank: false, unique: false, maxSize: 50
        orderDate nullable: false, unique: false
        workOrderNo nullable: true, blank: true, unique: false
        sysrefRevenueType nullable: true, unique: false
        billingNo nullable: true, blank: true, unique: false, maxSize: 50
    }

    static mapping = {
//        table name: "order", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_ORDER']
    }


}
