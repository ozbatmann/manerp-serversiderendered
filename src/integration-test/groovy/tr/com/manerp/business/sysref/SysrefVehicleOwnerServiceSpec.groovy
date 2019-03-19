package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefVehicleOwnerServiceSpec extends Specification {

    SysrefVehicleOwnerService sysrefVehicleOwnerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefVehicleOwner(...).save(flush: true, failOnError: true)
        //new SysrefVehicleOwner(...).save(flush: true, failOnError: true)
        //SysrefVehicleOwner sysrefVehicleOwner = new SysrefVehicleOwner(...).save(flush: true, failOnError: true)
        //new SysrefVehicleOwner(...).save(flush: true, failOnError: true)
        //new SysrefVehicleOwner(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefVehicleOwner.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefVehicleOwnerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefVehicleOwner> sysrefVehicleOwnerList = sysrefVehicleOwnerService.list(max: 2, offset: 2)

        then:
        sysrefVehicleOwnerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefVehicleOwnerService.count() == 5
    }

    void "test delete"() {
        Long sysrefVehicleOwnerId = setupData()

        expect:
        sysrefVehicleOwnerService.count() == 5

        when:
        sysrefVehicleOwnerService.delete(sysrefVehicleOwnerId)
        sessionFactory.currentSession.flush()

        then:
        sysrefVehicleOwnerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefVehicleOwner sysrefVehicleOwner = new SysrefVehicleOwner()
        sysrefVehicleOwnerService.save(sysrefVehicleOwner)

        then:
        sysrefVehicleOwner.id != null
    }
}
