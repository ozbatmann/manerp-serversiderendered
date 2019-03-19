package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefCompanyTypeServiceSpec extends Specification {

    SysrefCompanyTypeService sysrefCompanyTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefCompanyType(...).save(flush: true, failOnError: true)
        //new SysrefCompanyType(...).save(flush: true, failOnError: true)
        //SysrefCompanyType sysrefCompanyType = new SysrefCompanyType(...).save(flush: true, failOnError: true)
        //new SysrefCompanyType(...).save(flush: true, failOnError: true)
        //new SysrefCompanyType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefCompanyType.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefCompanyTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefCompanyType> sysrefCompanyTypeList = sysrefCompanyTypeService.list(max: 2, offset: 2)

        then:
        sysrefCompanyTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefCompanyTypeService.count() == 5
    }

    void "test delete"() {
        Long sysrefCompanyTypeId = setupData()

        expect:
        sysrefCompanyTypeService.count() == 5

        when:
        sysrefCompanyTypeService.delete(sysrefCompanyTypeId)
        sessionFactory.currentSession.flush()

        then:
        sysrefCompanyTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefCompanyType sysrefCompanyType = new SysrefCompanyType()
        sysrefCompanyTypeService.save(sysrefCompanyType)

        then:
        sysrefCompanyType.id != null
    }
}
