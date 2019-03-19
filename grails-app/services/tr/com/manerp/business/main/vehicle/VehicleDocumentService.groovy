package tr.com.manerp.business.main.vehicle

import grails.gorm.services.Service

@Service(VehicleDocument)
interface VehicleDocumentService {

    VehicleDocument get(Serializable id)

    List<VehicleDocument> list(Map args)

    Long count()

    void delete(Serializable id)

    VehicleDocument save(VehicleDocument vehicleDocument)

}