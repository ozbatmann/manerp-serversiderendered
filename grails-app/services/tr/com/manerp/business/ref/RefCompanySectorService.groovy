package tr.com.manerp.business.ref

import grails.gorm.services.Service

@Service(RefCompanySector)
interface RefCompanySectorService {

    RefCompanySector get(Serializable id)

    List<RefCompanySector> list(Map args)

    Long count()

    void delete(Serializable id)

    RefCompanySector save(RefCompanySector refCompanySector)

}