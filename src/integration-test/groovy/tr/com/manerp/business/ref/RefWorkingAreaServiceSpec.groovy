package tr.com.manerp.business.ref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RefWorkingAreaServiceSpec extends Specification {

    RefWorkingAreaService refWorkingAreaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RefWorkingArea(...).save(flush: true, failOnError: true)
        //new RefWorkingArea(...).save(flush: true, failOnError: true)
        //RefWorkingArea refWorkingArea = new RefWorkingArea(...).save(flush: true, failOnError: true)
        //new RefWorkingArea(...).save(flush: true, failOnError: true)
        //new RefWorkingArea(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //refWorkingArea.id
    }

    void "test get"() {
        setupData()

        expect:
        refWorkingAreaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RefWorkingArea> refWorkingAreaList = refWorkingAreaService.list(max: 2, offset: 2)

        then:
        refWorkingAreaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        refWorkingAreaService.count() == 5
    }

    void "test delete"() {
        Long refWorkingAreaId = setupData()

        expect:
        refWorkingAreaService.count() == 5

        when:
        refWorkingAreaService.delete(refWorkingAreaId)
        sessionFactory.currentSession.flush()

        then:
        refWorkingAreaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RefWorkingArea refWorkingArea = new RefWorkingArea()
        refWorkingAreaService.save(refWorkingArea)

        then:
        refWorkingArea.id != null
    }
}
