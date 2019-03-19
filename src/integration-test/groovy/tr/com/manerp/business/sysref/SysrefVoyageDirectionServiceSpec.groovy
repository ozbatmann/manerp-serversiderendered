package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefVoyageDirectionServiceSpec extends Specification {

    SysrefVoyageDirectionService sysrefVoyageDirectionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefVoyageDirection(...).save(flush: true, failOnError: true)
        //new SysrefVoyageDirection(...).save(flush: true, failOnError: true)
        //SysrefVoyageDirection sysrefVoyageDirection = new SysrefVoyageDirection(...).save(flush: true, failOnError: true)
        //new SysrefVoyageDirection(...).save(flush: true, failOnError: true)
        //new SysrefVoyageDirection(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefVoyageDirection.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefVoyageDirectionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefVoyageDirection> sysrefVoyageDirectionList = sysrefVoyageDirectionService.list(max: 2, offset: 2)

        then:
        sysrefVoyageDirectionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefVoyageDirectionService.count() == 5
    }

    void "test delete"() {
        Long sysrefVoyageDirectionId = setupData()

        expect:
        sysrefVoyageDirectionService.count() == 5

        when:
        sysrefVoyageDirectionService.delete(sysrefVoyageDirectionId)
        sessionFactory.currentSession.flush()

        then:
        sysrefVoyageDirectionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefVoyageDirection sysrefVoyageDirection = new SysrefVoyageDirection()
        sysrefVoyageDirectionService.save(sysrefVoyageDirection)

        then:
        sysrefVoyageDirection.id != null
    }
}
