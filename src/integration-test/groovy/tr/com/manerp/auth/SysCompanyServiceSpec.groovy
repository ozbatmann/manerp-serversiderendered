package tr.com.manerp.auth

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysCompanyServiceSpec extends Specification {

    SysCompanyService sysCompanyService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysCompany(...).save(flush: true, failOnError: true)
        //new SysCompany(...).save(flush: true, failOnError: true)
        //SysCompany sysCompany = new SysCompany(...).save(flush: true, failOnError: true)
        //new SysCompany(...).save(flush: true, failOnError: true)
        //new SysCompany(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysCompany.id
    }

    void "test get"() {
        setupData()

        expect:
        sysCompanyService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysCompany> sysCompanyList = sysCompanyService.list(max: 2, offset: 2)

        then:
        sysCompanyList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysCompanyService.count() == 5
    }

    void "test delete"() {
        Long sysCompanyId = setupData()

        expect:
        sysCompanyService.count() == 5

        when:
        sysCompanyService.delete(sysCompanyId)
        sessionFactory.currentSession.flush()

        then:
        sysCompanyService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysCompany sysCompany = new SysCompany()
        sysCompanyService.save(sysCompany)

        then:
        sysCompany.id != null
    }
}
