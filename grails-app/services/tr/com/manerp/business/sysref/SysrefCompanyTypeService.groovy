package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefCompanyType)
interface SysrefCompanyTypeService {

    SysrefCompanyType get(Serializable id)

    List<SysrefCompanyType> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefCompanyType save(SysrefCompanyType sysrefCompanyType)

}