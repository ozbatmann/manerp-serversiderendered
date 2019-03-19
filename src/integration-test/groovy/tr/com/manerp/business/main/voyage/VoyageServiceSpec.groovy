package tr.com.manerp.business.main.voyage

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VoyageServiceSpec extends Specification {

    VoyageService voyageService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Voyage(...).save(flush: true, failOnError: true)
        //new Voyage(...).save(flush: true, failOnError: true)
        //Voyage voyage = new Voyage(...).save(flush: true, failOnError: true)
        //new Voyage(...).save(flush: true, failOnError: true)
        //new Voyage(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //voyage.id
    }

    void "test get"() {
        setupData()

        expect:
        voyageService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Voyage> voyageList = voyageService.list(max: 2, offset: 2)

        then:
        voyageList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        voyageService.count() == 5
    }

    void "test delete"() {
        Long voyageId = setupData()

        expect:
        voyageService.count() == 5

        when:
        voyageService.delete(voyageId)
        sessionFactory.currentSession.flush()

        then:
        voyageService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Voyage voyage = new Voyage()
        voyageService.save(voyage)

        then:
        voyage.id != null
    }
}
