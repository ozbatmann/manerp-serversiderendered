package tr.com.manerp.business.main.vehicle

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DorsetServiceSpec extends Specification {

    DorsetService dorsetService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Dorset(...).save(flush: true, failOnError: true)
        //new Dorset(...).save(flush: true, failOnError: true)
        //Dorset dorset = new Dorset(...).save(flush: true, failOnError: true)
        //new Dorset(...).save(flush: true, failOnError: true)
        //new Dorset(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dorset.id
    }

    void "test get"() {
        setupData()

        expect:
        dorsetService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Dorset> dorsetList = dorsetService.list(max: 2, offset: 2)

        then:
        dorsetList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dorsetService.count() == 5
    }

    void "test delete"() {
        Long dorsetId = setupData()

        expect:
        dorsetService.count() == 5

        when:
        dorsetService.delete(dorsetId)
        sessionFactory.currentSession.flush()

        then:
        dorsetService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Dorset dorset = new Dorset()
        dorsetService.save(dorset)

        then:
        dorset.id != null
    }
}
