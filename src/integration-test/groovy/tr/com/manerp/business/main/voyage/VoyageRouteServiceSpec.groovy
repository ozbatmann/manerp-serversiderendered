package tr.com.manerp.business.main.voyage

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VoyageRouteServiceSpec extends Specification {

    VoyageRouteService voyageRouteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VoyageRoute(...).save(flush: true, failOnError: true)
        //new VoyageRoute(...).save(flush: true, failOnError: true)
        //VoyageRoute voyageRoute = new VoyageRoute(...).save(flush: true, failOnError: true)
        //new VoyageRoute(...).save(flush: true, failOnError: true)
        //new VoyageRoute(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //voyageRoute.id
    }

    void "test get"() {
        setupData()

        expect:
        voyageRouteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VoyageRoute> voyageRouteList = voyageRouteService.list(max: 2, offset: 2)

        then:
        voyageRouteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        voyageRouteService.count() == 5
    }

    void "test delete"() {
        Long voyageRouteId = setupData()

        expect:
        voyageRouteService.count() == 5

        when:
        voyageRouteService.delete(voyageRouteId)
        sessionFactory.currentSession.flush()

        then:
        voyageRouteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VoyageRoute voyageRoute = new VoyageRoute()
        voyageRouteService.save(voyageRoute)

        then:
        voyageRoute.id != null
    }
}
