package tr.com.manerp.business.main.company

import grails.gorm.services.Service

@Service(Vendor)
interface VendorService {

    Vendor get(Serializable id)

    List<Vendor> list(Map args)

    Long count()

    void delete(Serializable id)

    Vendor save(Vendor vendor)

}