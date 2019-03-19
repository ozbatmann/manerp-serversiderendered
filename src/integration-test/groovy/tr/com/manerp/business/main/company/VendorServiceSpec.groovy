package tr.com.manerp.business.main.company

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorServiceSpec extends Specification {

    VendorService vendorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vendor(...).save(flush: true, failOnError: true)
        //new Vendor(...).save(flush: true, failOnError: true)
        //Vendor vendor = new Vendor(...).save(flush: true, failOnError: true)
        //new Vendor(...).save(flush: true, failOnError: true)
        //new Vendor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendor.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vendor> vendorList = vendorService.list(max: 2, offset: 2)

        then:
        vendorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorService.count() == 5
    }

    void "test delete"() {
        Long vendorId = setupData()

        expect:
        vendorService.count() == 5

        when:
        vendorService.delete(vendorId)
        sessionFactory.currentSession.flush()

        then:
        vendorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vendor vendor = new Vendor()
        vendorService.save(vendor)

        then:
        vendor.id != null
    }
}
