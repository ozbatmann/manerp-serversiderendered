package tr.com.manerp.business.main.vehicle

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TrailerServiceSpec extends Specification {

    TrailerService trailerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Trailer(...).save(flush: true, failOnError: true)
        //new Trailer(...).save(flush: true, failOnError: true)
        //Trailer trailer = new Trailer(...).save(flush: true, failOnError: true)
        //new Trailer(...).save(flush: true, failOnError: true)
        //new Trailer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //trailer.id
    }

    void "test get"() {
        setupData()

        expect:
        trailerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Trailer> trailerList = trailerService.list(max: 2, offset: 2)

        then:
        trailerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        trailerService.count() == 5
    }

    void "test delete"() {
        Long trailerId = setupData()

        expect:
        trailerService.count() == 5

        when:
        trailerService.delete(trailerId)
        sessionFactory.currentSession.flush()

        then:
        trailerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Trailer trailer = new Trailer()
        trailerService.save(trailer)

        then:
        trailer.id != null
    }
}
