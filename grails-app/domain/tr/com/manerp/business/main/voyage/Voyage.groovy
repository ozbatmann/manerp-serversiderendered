package tr.com.manerp.business.main.voyage

import tr.com.manerp.auth.SysCompany
import tr.com.manerp.base.domain.BaseDomain
import tr.com.manerp.business.main.company.Company
import tr.com.manerp.business.main.vehicle.Dorset
import tr.com.manerp.business.main.order.Order
import tr.com.manerp.business.main.resource.Staff
import tr.com.manerp.business.main.vehicle.Trailer
import tr.com.manerp.business.main.vehicle.Vehicle
import tr.com.manerp.business.sysref.SysrefDeliveryStatus
import tr.com.manerp.business.sysref.SysrefTransportationType
import tr.com.manerp.business.sysref.SysrefVoyageDirection

class Voyage implements BaseDomain {

    static auditable = true

    String code
    SysCompany sysCompany
    Company company
    Vehicle vehicle
    Staff driver
    Dorset dorset
    Trailer trailer
    Order order
    SysrefTransportationType sysrefTransportationType
    SysrefVoyageDirection sysrefVoyageDirection
    Location loadingLocation
    Location dumpingLocation
    Staff substitudeDriver // yedek sofor
    String transportWaybillNo
    String deliveryNoteNo
    String sasNumber
    SysrefDeliveryStatus sysrefDeliveryStatus

    static hasMany = [routes: VoyageRoute]

    static constraints = {
        code nullable: true, blank: true, unique: ['sysCompany'], maxSize: 11
        sysCompany nullable: false, unique: false
        company nullable: false, unique: false
        vehicle nullable: false, unique: false
        driver nullable: false, unique: false
        dorset nullable: true, unique: false
        trailer nullable: true, unique: false
        order nullable: false, unique: false
        sysrefTransportationType nullable: true, unique: false
        sysrefVoyageDirection nullable: true, unique: false
        loadingLocation nullable: false, unique: false
        dumpingLocation nullable: false, unique: false
        substitudeDriver nullable: true, unique: false
        transportWaybillNo nullable: false, blank: false, unique: false
        deliveryNoteNo nullable: false, blank: false, unique: false
        sasNumber nullable: false, blank: false, unique: false
        sysrefDeliveryStatus nullable: true, unique: false
    }

    static mapping = {
//        table name: "voyage", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_VOYAGE']
        routes cascade: 'all-delete-orphan'
    }


}
