package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefDistrictServiceSpec extends Specification {

    SysrefDistrictService sysrefDistrictService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefDistrict(...).save(flush: true, failOnError: true)
        //new SysrefDistrict(...).save(flush: true, failOnError: true)
        //SysrefDistrict sysrefDistrict = new SysrefDistrict(...).save(flush: true, failOnError: true)
        //new SysrefDistrict(...).save(flush: true, failOnError: true)
        //new SysrefDistrict(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefDistrict.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefDistrictService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefDistrict> sysrefDistrictList = sysrefDistrictService.list(max: 2, offset: 2)

        then:
        sysrefDistrictList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefDistrictService.count() == 5
    }

    void "test delete"() {
        Long sysrefDistrictId = setupData()

        expect:
        sysrefDistrictService.count() == 5

        when:
        sysrefDistrictService.delete(sysrefDistrictId)
        sessionFactory.currentSession.flush()

        then:
        sysrefDistrictService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefDistrict sysrefDistrict = new SysrefDistrict()
        sysrefDistrictService.save(sysrefDistrict)

        then:
        sysrefDistrict.id != null
    }
}
