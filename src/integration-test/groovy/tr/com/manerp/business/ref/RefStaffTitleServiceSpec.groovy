package tr.com.manerp.business.ref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RefStaffTitleServiceSpec extends Specification {

    RefStaffTitleService refStaffTitleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RefStaffTitle(...).save(flush: true, failOnError: true)
        //new RefStaffTitle(...).save(flush: true, failOnError: true)
        //RefStaffTitle refStaffTitle = new RefStaffTitle(...).save(flush: true, failOnError: true)
        //new RefStaffTitle(...).save(flush: true, failOnError: true)
        //new RefStaffTitle(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //refStaffTitle.id
    }

    void "test get"() {
        setupData()

        expect:
        refStaffTitleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RefStaffTitle> refStaffTitleList = refStaffTitleService.list(max: 2, offset: 2)

        then:
        refStaffTitleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        refStaffTitleService.count() == 5
    }

    void "test delete"() {
        Long refStaffTitleId = setupData()

        expect:
        refStaffTitleService.count() == 5

        when:
        refStaffTitleService.delete(refStaffTitleId)
        sessionFactory.currentSession.flush()

        then:
        refStaffTitleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RefStaffTitle refStaffTitle = new RefStaffTitle()
        refStaffTitleService.save(refStaffTitle)

        then:
        refStaffTitle.id != null
    }
}
