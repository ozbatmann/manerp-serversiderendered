package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefCity)
interface SysrefCityService {

    SysrefCity get(Serializable id)

    List<SysrefCity> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefCity save(SysrefCity sysrefCity)

}