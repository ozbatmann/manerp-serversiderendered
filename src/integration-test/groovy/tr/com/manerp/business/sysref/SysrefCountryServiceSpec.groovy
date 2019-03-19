package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefCountryServiceSpec extends Specification {

    SysrefCountryService sysrefCountryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefCountry(...).save(flush: true, failOnError: true)
        //new SysrefCountry(...).save(flush: true, failOnError: true)
        //SysrefCountry sysrefCountry = new SysrefCountry(...).save(flush: true, failOnError: true)
        //new SysrefCountry(...).save(flush: true, failOnError: true)
        //new SysrefCountry(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefCountry.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefCountryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefCountry> sysrefCountryList = sysrefCountryService.list(max: 2, offset: 2)

        then:
        sysrefCountryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefCountryService.count() == 5
    }

    void "test delete"() {
        Long sysrefCountryId = setupData()

        expect:
        sysrefCountryService.count() == 5

        when:
        sysrefCountryService.delete(sysrefCountryId)
        sessionFactory.currentSession.flush()

        then:
        sysrefCountryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefCountry sysrefCountry = new SysrefCountry()
        sysrefCountryService.save(sysrefCountry)

        then:
        sysrefCountry.id != null
    }
}
