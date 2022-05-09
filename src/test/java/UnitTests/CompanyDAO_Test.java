package UnitTests;


import dao.CompanyDAO;
import model.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CompanyDAO_Test {

    Company firstCompany = new Company();
    Company secondCompany = new Company();

    @BeforeEach
    public void init() {
        if(CompanyDAO.readCompanies().size() < 2) {
            CompanyDAO.saveCompany(new Company(1, "Company B", null, null, null, null));
        }
        Company co1 = CompanyDAO.getCompany(1);
        Company co2 = CompanyDAO.getCompany(2);
        firstCompany = co1;
        secondCompany = co2;
    }

    @Test
    public void readCompaniesTest() {
        List<Company> expectedListOfCompanies = new ArrayList<>();
        expectedListOfCompanies.add(firstCompany);
        expectedListOfCompanies.add(secondCompany);
        Assertions.assertEquals(CompanyDAO.readCompanies().size(), expectedListOfCompanies.size());
    }


}
