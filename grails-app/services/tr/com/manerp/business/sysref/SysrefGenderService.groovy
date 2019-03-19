package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefGender)
interface SysrefGenderService {

    SysrefGender get(Serializable id)

    List<SysrefGender> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefGender save(SysrefGender sysrefGender)

}