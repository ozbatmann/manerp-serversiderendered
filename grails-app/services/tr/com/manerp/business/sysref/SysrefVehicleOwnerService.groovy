package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefVehicleOwner)
interface SysrefVehicleOwnerService {

    SysrefVehicleOwner get(Serializable id)

    List<SysrefVehicleOwner> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefVehicleOwner save(SysrefVehicleOwner sysrefVehicleOwner)

}