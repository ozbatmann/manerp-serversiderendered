package tr.com.manerp.business.main.voyage

import grails.gorm.services.Service

@Service(Voyage)
interface VoyageService {

    Voyage get(Serializable id)

    List<Voyage> list(Map args)

    Long count()

    void delete(Serializable id)

    Voyage save(Voyage voyage)

}