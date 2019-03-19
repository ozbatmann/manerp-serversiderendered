package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefVehicleType)
interface SysrefVehicleTypeService {

    SysrefVehicleType get(Serializable id)

    List<SysrefVehicleType> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefVehicleType save(SysrefVehicleType sysrefVehicleType)

}