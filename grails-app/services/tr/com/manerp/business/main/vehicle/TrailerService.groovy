package tr.com.manerp.business.main.vehicle

import grails.gorm.services.Service

@Service(Trailer)
interface TrailerService {

    Trailer get(Serializable id)

    List<Trailer> list(Map args)

    Long count()

    void delete(Serializable id)

    Trailer save(Trailer trailer)

}