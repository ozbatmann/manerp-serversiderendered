package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefVehicleTypeServiceSpec extends Specification {

    SysrefVehicleTypeService sysrefVehicleTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefVehicleType(...).save(flush: true, failOnError: true)
        //new SysrefVehicleType(...).save(flush: true, failOnError: true)
        //SysrefVehicleType sysrefVehicleType = new SysrefVehicleType(...).save(flush: true, failOnError: true)
        //new SysrefVehicleType(...).save(flush: true, failOnError: true)
        //new SysrefVehicleType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefVehicleType.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefVehicleTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefVehicleType> sysrefVehicleTypeList = sysrefVehicleTypeService.list(max: 2, offset: 2)

        then:
        sysrefVehicleTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefVehicleTypeService.count() == 5
    }

    void "test delete"() {
        Long sysrefVehicleTypeId = setupData()

        expect:
        sysrefVehicleTypeService.count() == 5

        when:
        sysrefVehicleTypeService.delete(sysrefVehicleTypeId)
        sessionFactory.currentSession.flush()

        then:
        sysrefVehicleTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefVehicleType sysrefVehicleType = new SysrefVehicleType()
        sysrefVehicleTypeService.save(sysrefVehicleType)

        then:
        sysrefVehicleType.id != null
    }
}
