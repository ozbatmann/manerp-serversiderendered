package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefCityServiceSpec extends Specification {

    SysrefCityService sysrefCityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefCity(...).save(flush: true, failOnError: true)
        //new SysrefCity(...).save(flush: true, failOnError: true)
        //SysrefCity sysrefCity = new SysrefCity(...).save(flush: true, failOnError: true)
        //new SysrefCity(...).save(flush: true, failOnError: true)
        //new SysrefCity(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefCity.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefCityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefCity> sysrefCityList = sysrefCityService.list(max: 2, offset: 2)

        then:
        sysrefCityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefCityService.count() == 5
    }

    void "test delete"() {
        Long sysrefCityId = setupData()

        expect:
        sysrefCityService.count() == 5

        when:
        sysrefCityService.delete(sysrefCityId)
        sessionFactory.currentSession.flush()

        then:
        sysrefCityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefCity sysrefCity = new SysrefCity()
        sysrefCityService.save(sysrefCity)

        then:
        sysrefCity.id != null
    }
}
