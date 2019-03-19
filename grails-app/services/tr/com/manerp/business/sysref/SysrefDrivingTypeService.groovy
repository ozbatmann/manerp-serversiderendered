package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefDrivingType)
interface SysrefDrivingTypeService {

    SysrefDrivingType get(Serializable id)

    List<SysrefDrivingType> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefDrivingType save(SysrefDrivingType sysrefDrivingType)

}