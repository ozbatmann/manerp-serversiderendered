package tr.com.manerp.business.ref

import grails.gorm.services.Service

@Service(RefStaffTitle)
interface RefStaffTitleService {

    RefStaffTitle get(Serializable id)

    List<RefStaffTitle> list(Map args)

    Long count()

    void delete(Serializable id)

    RefStaffTitle save(RefStaffTitle refStaffTitle)

}