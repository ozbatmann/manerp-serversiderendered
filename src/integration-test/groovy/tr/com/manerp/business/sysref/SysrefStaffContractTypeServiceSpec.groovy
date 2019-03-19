package tr.com.manerp.business.sysref

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SysrefStaffContractTypeServiceSpec extends Specification {

    SysrefStaffContractTypeService sysrefStaffContractTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SysrefStaffContractType(...).save(flush: true, failOnError: true)
        //new SysrefStaffContractType(...).save(flush: true, failOnError: true)
        //SysrefStaffContractType sysrefStaffContractType = new SysrefStaffContractType(...).save(flush: true, failOnError: true)
        //new SysrefStaffContractType(...).save(flush: true, failOnError: true)
        //new SysrefStaffContractType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sysrefStaffContractType.id
    }

    void "test get"() {
        setupData()

        expect:
        sysrefStaffContractTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SysrefStaffContractType> sysrefStaffContractTypeList = sysrefStaffContractTypeService.list(max: 2, offset: 2)

        then:
        sysrefStaffContractTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sysrefStaffContractTypeService.count() == 5
    }

    void "test delete"() {
        Long sysrefStaffContractTypeId = setupData()

        expect:
        sysrefStaffContractTypeService.count() == 5

        when:
        sysrefStaffContractTypeService.delete(sysrefStaffContractTypeId)
        sessionFactory.currentSession.flush()

        then:
        sysrefStaffContractTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SysrefStaffContractType sysrefStaffContractType = new SysrefStaffContractType()
        sysrefStaffContractTypeService.save(sysrefStaffContractType)

        then:
        sysrefStaffContractType.id != null
    }
}
