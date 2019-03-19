package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefNaceCode)
interface SysrefNaceCodeService {

    SysrefNaceCode get(Serializable id)

    List<SysrefNaceCode> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefNaceCode save(SysrefNaceCode sysrefNaceCode)

}