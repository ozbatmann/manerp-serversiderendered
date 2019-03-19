package tr.com.manerp.business.main.vehicle

import grails.databinding.BindingFormat
import tr.com.manerp.auth.SysCompany
import tr.com.manerp.base.domain.BaseDomain
import tr.com.manerp.business.ref.RefWorkingArea
import tr.com.manerp.business.sysref.SysrefVehicleOwner
import tr.com.manerp.business.sysref.SysrefVehicleType

class Vehicle implements BaseDomain {

    static auditable = true

    String code
    SysCompany sysCompany
    String brand
    String fleetCardNumber
    String plateNumber
    @BindingFormat('yyyy-MM-dd’T’HH:mm:ssZ')
    Date purchaseDate
    Short numberOfSensors
    Boolean hasLogo
    Integer km
    Boolean isDualRegime
    RefWorkingArea refWorkingArea
    SysrefVehicleType sysrefVehicleType
    SysrefVehicleOwner sysrefVehicleOwner
    String vehicleOwnerName
    @BindingFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    Date insuranceStartDate
    @BindingFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    Date insuranceEndDate
    String kgsNo
    String ogsNo
    String fuelKit
    String description
    Boolean operationInsuranceNotification
    Boolean annualInsurance

    static hasMany = [
        vehicleDocuments: VehicleDocument
    ]
    static belongsTo = []

    static constraints = {
        code nullable: true, blank: true, unique: ['sysCompany'], maxSize: 11
        sysCompany nullable: false, unique: false
        brand nullable: false, blank: false, unique: false, maxSize: 50
        fleetCardNumber nullable: false, unique: false, maxSize: 50
        plateNumber nullable: false, blank: false, unique: ['sysCompany'], maxSize: 12
        purchaseDate nullable: true, unique: false
        numberOfSensors nullable: true, unique: false
        hasLogo nullable: false, unique: false
        km nullable: true, unique: false
        isDualRegime nullable: false, unique: false
        refWorkingArea nullable: true, unique: false
        sysrefVehicleType nullable: false, unique: false
        sysrefVehicleOwner nullable: false, unique: false
        vehicleOwnerName nullable: true, unique: false, maxSize: 50
        insuranceStartDate nullable: true, unique: false
        insuranceEndDate nullable: true, unique: false
        kgsNo nullable: true, blank: true, unique: false, maxSize: 50
        ogsNo nullable: true, blank: true, unique: false, maxSize: 50
        fuelKit nullable: true, blank: true, unique: false, maxSize: 50
        description nullable: true, blank: true, unique: false
        operationInsuranceNotification nullable: true, unique: false
        annualInsurance nullable: true, unique: false
    }

    static mapping = {
//        table name: "vehicle", schema: "business"
//        id generator: 'sequence', params: [sequence: 'business.SEQ_VEHICLE']
        vehicleDocuments cascade: 'all-delete-orphan'
    }


    def beforeValidate() {
        brand = brand?.trim()
        fleetCardNumber = fleetCardNumber?.trim()
        plateNumber = plateNumber?.trim()
        vehicleOwnerName = vehicleOwnerName?.trim()
        kgsNo = kgsNo?.trim()
        ogsNo = ogsNo?.trim()
    }

}
