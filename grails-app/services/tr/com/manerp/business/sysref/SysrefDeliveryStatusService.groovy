package tr.com.manerp.business.sysref

import grails.gorm.services.Service

@Service(SysrefDeliveryStatus)
interface SysrefDeliveryStatusService {

    SysrefDeliveryStatus get(Serializable id)

    List<SysrefDeliveryStatus> list(Map args)

    Long count()

    void delete(Serializable id)

    SysrefDeliveryStatus save(SysrefDeliveryStatus sysrefDeliveryStatus)

}