package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefVoyageDirection)
interface SysrefVoyageDirectionService {

    SysrefVoyageDirection get(Serializable id)

    List<SysrefVoyageDirection> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefVoyageDirection save(SysrefVoyageDirection sysrefVoyageDirection)

}