package tr.com.manerp.business.ref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RefCompanySectorServiceSpec extends Specification {

    RefCompanySectorService refCompanySectorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RefCompanySector(...).save(flush: true, failOnError: true)
        //new RefCompanySector(...).save(flush: true, failOnError: true)
        //RefCompanySector refCompanySector = new RefCompanySector(...).save(flush: true, failOnError: true)
        //new RefCompanySector(...).save(flush: true, failOnError: true)
        //new RefCompanySector(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //refCompanySector.id
    }

    void "test get"() {
        setupData()

        expect:
        refCompanySectorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RefCompanySector> refCompanySectorList = refCompanySectorService.list(max: 2, offset: 2)

        then:
        refCompanySectorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        refCompanySectorService.count() == 5
    }

    void "test delete"() {
        Long refCompanySectorId = setupData()

        expect:
        refCompanySectorService.count() == 5

        when:
        refCompanySectorService.delete(refCompanySectorId)
        sessionFactory.currentSession.flush()

        then:
        refCompanySectorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RefCompanySector refCompanySector = new RefCompanySector()
        refCompanySectorService.save(refCompanySector)

        then:
        refCompanySector.id != null
    }
}
