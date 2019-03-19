package tr.com.manerp.business.main.vehicle

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VehicleDocumentServiceSpec extends Specification {

    VehicleDocumentService vehicleDocumentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VehicleDocument(...).save(flush: true, failOnError: true)
        //new VehicleDocument(...).save(flush: true, failOnError: true)
        //VehicleDocument vehicleDocument = new VehicleDocument(...).save(flush: true, failOnError: true)
        //new VehicleDocument(...).save(flush: true, failOnError: true)
        //new VehicleDocument(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vehicleDocument.id
    }

    void "test get"() {
        setupData()

        expect:
        vehicleDocumentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VehicleDocument> vehicleDocumentList = vehicleDocumentService.list(max: 2, offset: 2)

        then:
        vehicleDocumentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vehicleDocumentService.count() == 5
    }

    void "test delete"() {
        Long vehicleDocumentId = setupData()

        expect:
        vehicleDocumentService.count() == 5

        when:
        vehicleDocumentService.delete(vehicleDocumentId)
        sessionFactory.currentSession.flush()

        then:
        vehicleDocumentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VehicleDocument vehicleDocument = new VehicleDocument()
        vehicleDocumentService.save(vehicleDocument)

        then:
        vehicleDocument.id != null
    }
}
