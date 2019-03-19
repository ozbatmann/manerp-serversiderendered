package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefDistrict)
interface SysrefDistrictService {

    SysrefDistrict get(Serializable id)

    List<SysrefDistrict> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefDistrict save(SysrefDistrict sysrefDistrict)

}