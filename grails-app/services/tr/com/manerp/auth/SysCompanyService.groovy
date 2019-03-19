package tr.com.manerp.auth

import grails.gorm.services.Service

@Service(SysCompany)
interface SysCompanyService {

    SysCompany get(Serializable id)

    List<SysCompany> list(Map args)

    Long count()

    void delete(Serializable id)

    SysCompany save(SysCompany sysCompany)

}