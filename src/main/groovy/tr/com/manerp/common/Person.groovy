package tr.com.manerp.common

import grails.databinding.BindingFormat
import tr.com.manerp.business.sysref.SysrefCity
import tr.com.manerp.business.sysref.SysrefCountry
import tr.com.manerp.business.sysref.SysrefDistrict
import tr.com.manerp.business.sysref.SysrefGender

trait Person {
    String firstName
    String middleName
    String lastName
    String email
    SysrefGender sysrefGender
    Long tcIdNumber
    Boolean isStaff
    byte[] photo
    String photoName
    String photoMimeType
    @BindingFormat('dd/MM/yyyy')
    Date birthDate
    String gsmNo
    String homePhone
    SysrefCountry sysrefCountry
    SysrefCity sysrefCity
    SysrefDistrict sysrefDistrict
    String address
}