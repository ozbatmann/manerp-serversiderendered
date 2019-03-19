package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefNaceCodeServiceSpec extends Specification {

    SysrefNaceCodeService sysrefNaceCodeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefNaceCode(...).save(flush: true, failOnError: true)
        //new SysrefNaceCode(...).save(flush: true, failOnError: true)
        //SysrefNaceCode sysrefNaceCode = new SysrefNaceCode(...).save(flush: true, failOnError: true)
        //new SysrefNaceCode(...).save(flush: true, failOnError: true)
        //new SysrefNaceCode(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefNaceCode.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefNaceCodeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefNaceCode> sysrefNaceCodeList = sysrefNaceCodeService.list(max: 2, offset: 2)

        then:
        sysrefNaceCodeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefNaceCodeService.count() == 5
    }

    void "test delete"() {
        Long sysrefNaceCodeId = setupData()

        expect:
        sysrefNaceCodeService.count() == 5

        when:
        sysrefNaceCodeService.delete(sysrefNaceCodeId)
        sessionFactory.currentSession.flush()

        then:
        sysrefNaceCodeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefNaceCode sysrefNaceCode = new SysrefNaceCode()
        sysrefNaceCodeService.save(sysrefNaceCode)

        then:
        sysrefNaceCode.id != null
    }
}
