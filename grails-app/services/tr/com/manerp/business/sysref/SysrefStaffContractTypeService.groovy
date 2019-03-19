package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefStaffContractType)
interface SysrefStaffContractTypeService {

    SysrefStaffContractType get(Serializable id)

    List<SysrefStaffContractType> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefStaffContractType save(SysrefStaffContractType sysrefStaffContractType)

}