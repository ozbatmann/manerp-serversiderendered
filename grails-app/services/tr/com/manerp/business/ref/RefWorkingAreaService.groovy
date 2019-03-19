package tr.com.manerp.business.ref

import grails.gorm.services.Service

@Service(RefWorkingArea)
interface RefWorkingAreaService {

    RefWorkingArea get(Serializable id)

    List<RefWorkingArea> list(Map args)

    Long count()

    void delete(Serializable id)

    RefWorkingArea save(RefWorkingArea refWorkingArea)

}