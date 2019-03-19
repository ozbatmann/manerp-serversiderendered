package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefRevenueType)
interface SysrefRevenueTypeService {

    SysrefRevenueType get(Serializable id)

    List<SysrefRevenueType> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefRevenueType save(SysrefRevenueType sysrefRevenueType)

}