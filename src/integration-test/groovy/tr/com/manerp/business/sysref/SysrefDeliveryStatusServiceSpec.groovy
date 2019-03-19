package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefDeliveryStatusServiceSpec extends Specification {

    SysrefDeliveryStatusService sysrefDeliveryStatusService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefDeliveryStatus(...).save(flush: true, failOnError: true)
        //new SysrefDeliveryStatus(...).save(flush: true, failOnError: true)
        //SysrefDeliveryStatus sysrefDeliveryStatus = new SysrefDeliveryStatus(...).save(flush: true, failOnError: true)
        //new SysrefDeliveryStatus(...).save(flush: true, failOnError: true)
        //new SysrefDeliveryStatus(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefDeliveryStatus.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefDeliveryStatusService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefDeliveryStatus> sysrefDeliveryStatusList = sysrefDeliveryStatusService.list(max: 2, offset: 2)

        then:
        sysrefDeliveryStatusList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefDeliveryStatusService.count() == 5
    }

    void "test delete"() {
        Long sysrefDeliveryStatusId = setupData()

        expect:
        sysrefDeliveryStatusService.count() == 5

        when:
        sysrefDeliveryStatusService.delete(sysrefDeliveryStatusId)
        sessionFactory.currentSession.flush()

        then:
        sysrefDeliveryStatusService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefDeliveryStatus sysrefDeliveryStatus = new SysrefDeliveryStatus()
        sysrefDeliveryStatusService.save(sysrefDeliveryStatus)

        then:
        sysrefDeliveryStatus.id != null
    }
}
