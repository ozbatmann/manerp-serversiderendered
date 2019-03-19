package tr.com.manerp.business.main.vehicle

import grails.gorm.services.Service

@Service(Dorset)
interface DorsetService {

    Dorset get(Serializable id)

    List<Dorset> list(Map args)

    Long count()

    void delete(Serializable id)

    Dorset save(Dorset dorset)

}