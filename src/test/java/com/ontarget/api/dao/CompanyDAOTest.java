package com.ontarget.api.dao;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.Company;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.fail;

/**
 * Created by Owner on 11/5/14.
 */
public class CompanyDAOTest extends BaseTest {

    private Logger logger = Logger.getLogger(CompanyDAOTest.class);

    @Autowired
    private CompanyDAO companyDAO;

    @Test
    public void testAddCompanyInfo(){

       Company comp = new Company();
        comp.setCompanyName("The TTG Inc.");
        comp.setCompanyTypeId(1);
        comp.setEmail("company@company.com");
        comp.setWebsite("http://www.comp.com");

        AddressDTO address=new AddressDTO();
        address.setAddress1("4750 59th street");
        address.setAddress2("Apt #9C");
        address.setCity("Woodside");
        address.setState("NY");
        address.setZip("11377");
        address.setCountry("USA");
        address.setAddressType("COMPANY");
        comp.setAddress(address);

        try {
            int returnId = companyDAO.addCompanyInfo(comp);

            Assert.assertTrue(returnId > 0);

        } catch (Exception e) {
            logger.error("Fail to add company",e);
            fail();
        }


    }


}
