package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefTransportationType)
interface SysrefTransportationTypeService {

    SysrefTransportationType get(Serializable id)

    List<SysrefTransportationType> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefTransportationType save(SysrefTransportationType sysrefTransportationType)

}