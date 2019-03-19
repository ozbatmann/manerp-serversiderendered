package tr.com.manerp.business.main.voyage

import grails.gorm.services.Service

@Service(VoyageRoute)
interface VoyageRouteService {

    VoyageRoute get(Serializable id)

    List<VoyageRoute> list(Map args)

    Long count()

    void delete(Serializable id)

    VoyageRoute save(VoyageRoute voyageRoute)

}