package tr.com.manerp.business.main.voyage

import grails.gorm.services.Service

@Service(Location)
interface LocationService {

    Location get(Serializable id)

    List<Location> list(Map args)

    Long count()

    void delete(Serializable id)

    Location save(Location location)

}