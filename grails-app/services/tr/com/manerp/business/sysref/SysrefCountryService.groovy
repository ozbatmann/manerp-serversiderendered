package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefCountry)
interface SysrefCountryService {

    SysrefCountry get(Serializable id)

    List<SysrefCountry> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefCountry save(SysrefCountry sysrefCountry)

}