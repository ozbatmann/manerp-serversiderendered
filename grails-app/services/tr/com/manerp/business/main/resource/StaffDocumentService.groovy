package tr.com.manerp.business.main.resource

import grails.gorm.services.Service

@Service(StaffDocument)
interface StaffDocumentService {

    StaffDocument get(Serializable id)

    List<StaffDocument> list(Map args)

    Long count()

    void delete(Serializable id)

    StaffDocument save(StaffDocument staffDocument)

}