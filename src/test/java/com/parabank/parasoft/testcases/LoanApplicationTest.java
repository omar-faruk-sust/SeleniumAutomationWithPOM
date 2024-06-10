package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.LoanApplicationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoanApplicationTest extends BaseTest {

    @Test
    public void loadApplicationShouldFailWithoutFillUpData() {
        LoanApplicationPage loanApplicationPage = loginAndGetAccountOverviewPage().clickRequestLoanLink().clickApplyBtn();

        Assert.assertTrue(loanApplicationPage.hasErrorAfterSubmit());
    }

    @Test
    public void loadApplicationShouldSuccessfullyProceed() {
        LoanApplicationPage loanApplicationPage =
                loginAndGetAccountOverviewPage()
                        .clickRequestLoanLink()
                        .fillLoanAmount(2.3f)
                        .fillDownPayment(10)
                        .selectAccount(0)
                        .clickApplyBtn();

        Assert.assertTrue(loanApplicationPage.hasLoanRetestSuccessful());
    }
}
