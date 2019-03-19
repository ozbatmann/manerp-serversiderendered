package tr.com.manerp.business.main.vehicle

import grails.gorm.services.Service

@Service(ArventoDevice)
interface ArventoDeviceService {

    ArventoDevice get(Serializable id)

    List<ArventoDevice> list(Map args)

    Long count()

    void delete(Serializable id)

    ArventoDevice save(ArventoDevice arventoDevice)

}