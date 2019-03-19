package tr.com.manerp.business.main.resource

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StaffDocumentServiceSpec extends Specification {

    StaffDocumentService staffDocumentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new StaffDocument(...).save(flush: true, failOnError: true)
        //new StaffDocument(...).save(flush: true, failOnError: true)
        //StaffDocument staffDocument = new StaffDocument(...).save(flush: true, failOnError: true)
        //new StaffDocument(...).save(flush: true, failOnError: true)
        //new StaffDocument(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //staffDocument.id
    }

    void "test get"() {
        setupData()

        expect:
        staffDocumentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<StaffDocument> staffDocumentList = staffDocumentService.list(max: 2, offset: 2)

        then:
        staffDocumentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        staffDocumentService.count() == 5
    }

    void "test delete"() {
        Long staffDocumentId = setupData()

        expect:
        staffDocumentService.count() == 5

        when:
        staffDocumentService.delete(staffDocumentId)
        sessionFactory.currentSession.flush()

        then:
        staffDocumentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        StaffDocument staffDocument = new StaffDocument()
        staffDocumentService.save(staffDocument)

        then:
        staffDocument.id != null
    }
}
