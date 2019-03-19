package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefRevenueTypeServiceSpec extends Specification {

    SysrefRevenueTypeService sysrefRevenueTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefRevenueType(...).save(flush: true, failOnError: true)
        //new SysrefRevenueType(...).save(flush: true, failOnError: true)
        //SysrefRevenueType sysrefRevenueType = new SysrefRevenueType(...).save(flush: true, failOnError: true)
        //new SysrefRevenueType(...).save(flush: true, failOnError: true)
        //new SysrefRevenueType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefRevenueType.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefRevenueTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefRevenueType> sysrefRevenueTypeList = sysrefRevenueTypeService.list(max: 2, offset: 2)

        then:
        sysrefRevenueTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefRevenueTypeService.count() == 5
    }

    void "test delete"() {
        Long sysrefRevenueTypeId = setupData()

        expect:
        sysrefRevenueTypeService.count() == 5

        when:
        sysrefRevenueTypeService.delete(sysrefRevenueTypeId)
        sessionFactory.currentSession.flush()

        then:
        sysrefRevenueTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefRevenueType sysrefRevenueType = new SysrefRevenueType()
        sysrefRevenueTypeService.save(sysrefRevenueType)

        then:
        sysrefRevenueType.id != null
    }
}
