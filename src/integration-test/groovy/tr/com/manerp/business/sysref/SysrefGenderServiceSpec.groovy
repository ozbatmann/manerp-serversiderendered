package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefGenderServiceSpec extends Specification {

    SysrefGenderService sysrefGenderService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefGender(...).save(flush: true, failOnError: true)
        //new SysrefGender(...).save(flush: true, failOnError: true)
        //SysrefGender sysrefGender = new SysrefGender(...).save(flush: true, failOnError: true)
        //new SysrefGender(...).save(flush: true, failOnError: true)
        //new SysrefGender(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefGender.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefGenderService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefGender> sysrefGenderList = sysrefGenderService.list(max: 2, offset: 2)

        then:
        sysrefGenderList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefGenderService.count() == 5
    }

    void "test delete"() {
        Long sysrefGenderId = setupData()

        expect:
        sysrefGenderService.count() == 5

        when:
        sysrefGenderService.delete(sysrefGenderId)
        sessionFactory.currentSession.flush()

        then:
        sysrefGenderService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefGender sysrefGender = new SysrefGender()
        sysrefGenderService.save(sysrefGender)

        then:
        sysrefGender.id != null
    }
}
