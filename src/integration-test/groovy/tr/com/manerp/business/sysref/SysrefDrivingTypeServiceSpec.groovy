package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefDrivingTypeServiceSpec extends Specification {

    SysrefDrivingTypeService sysrefDrivingTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefDrivingType(...).save(flush: true, failOnError: true)
        //new SysrefDrivingType(...).save(flush: true, failOnError: true)
        //SysrefDrivingType sysrefDrivingType = new SysrefDrivingType(...).save(flush: true, failOnError: true)
        //new SysrefDrivingType(...).save(flush: true, failOnError: true)
        //new SysrefDrivingType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefDrivingType.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefDrivingTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefDrivingType> sysrefDrivingTypeList = sysrefDrivingTypeService.list(max: 2, offset: 2)

        then:
        sysrefDrivingTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefDrivingTypeService.count() == 5
    }

    void "test delete"() {
        Long sysrefDrivingTypeId = setupData()

        expect:
        sysrefDrivingTypeService.count() == 5

        when:
        sysrefDrivingTypeService.delete(sysrefDrivingTypeId)
        sessionFactory.currentSession.flush()

        then:
        sysrefDrivingTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefDrivingType sysrefDrivingType = new SysrefDrivingType()
        sysrefDrivingTypeService.save(sysrefDrivingType)

        then:
        sysrefDrivingType.id != null
    }
}
