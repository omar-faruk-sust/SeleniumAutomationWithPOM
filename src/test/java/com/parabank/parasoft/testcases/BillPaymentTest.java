package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.BillPaymentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillPaymentTest extends BaseTest {

    @Test(enabled = true, priority = 1)
    public void doBillPaymentSuccessfully() throws InterruptedException {
        BillPaymentPage billPaymentPage = loginAndGetAccountOverviewPage()
                .clickBillPaymentLink()
                .fillPayeeName(dataFaker.getName())
                .fillAddress(dataFaker.getTitle(5))
                .fillCity(dataFaker.getCity())
                .fillState(dataFaker.getStateFull())
                .fillZipCode(dataFaker.getZipCode())
                .fillPhone(dataFaker.getPhone())
                .fillPayeeAccount("13333")
                .fillPayeeReAccount("13333")
                .fillAmount(1.4)
                .selectFromAccount(0)
                .clickSendPaymentBtn();

        Assert.assertTrue(billPaymentPage.hasBillPaymentComplete());
    }

    @Test(enabled = true, priority = 2)
    public void billPaymentShouldFail() {
        BillPaymentPage billPaymentPage = loginAndGetAccountOverviewPage()
                .clickBillPaymentLink()
                .fillPayeeName(dataFaker.getName())
                .fillAddress(dataFaker.getTitle(5))
                .fillCity(dataFaker.getCity())
                .fillState(dataFaker.getStateFull())
                .fillZipCode(dataFaker.getZipCode())
                .fillPhone(dataFaker.getPhone())
                .fillPayeeAccount("222222222222222222222")
                .fillPayeeReAccount("222222222222222222222")
                .fillAmount(1.4)
                .selectFromAccount(0)
                .clickPaymentBtnWithAllData();

        Assert.assertTrue(billPaymentPage.hasErrorAfterSendPayment());
    }

    @Test(enabled = true, priority = 3)
    public void billPaymentShouldFailWithoutFillingData() {
        BillPaymentPage billPaymentPage = loginAndGetAccountOverviewPage()
                .clickBillPaymentLink()
                .clickSendPaymentBtnWithoutRequiredData();

        Assert.assertTrue(billPaymentPage.hasPayeeNameRequiredFieldError());
        Assert.assertTrue(billPaymentPage.hasAddressRequiredFieldError());
        Assert.assertTrue(billPaymentPage.hasCityRequiredFieldError());
        Assert.assertTrue(billPaymentPage.hasStateRequiredFieldError());
        Assert.assertTrue(billPaymentPage.hasZipCodeErrorRequiredFieldError());
        Assert.assertTrue(billPaymentPage.hasPhoneNumberErrorRequiredFieldError());
        Assert.assertTrue(billPaymentPage.hasPayeeAccountRequiredFieldError());
        Assert.assertTrue(billPaymentPage.hasVerifyErrorRequiredFieldError());
        Assert.assertTrue(billPaymentPage.hasAmountEmptyErrorRequiredFieldError());
    }

    @Test(enabled = true, priority = 4)
    public void billPaymentShouldFailWithInvalidAccount() {
        BillPaymentPage billPaymentPage = loginAndGetAccountOverviewPage()
                .clickBillPaymentLink()
                .fillPayeeName(dataFaker.getName())
                .fillAddress(dataFaker.getTitle(5))
                .fillCity(dataFaker.getCity())
                .fillState(dataFaker.getStateFull())
                .fillZipCode(dataFaker.getZipCode())
                .fillPhone(dataFaker.getPhone())
                .fillPayeeAccount("AAAA")
                .fillPayeeReAccount("AAAA")
                .fillInvalidAmount("g6")
                .selectFromAccount(0)
                .clickPaymentBtnWithAllData();


        Assert.assertTrue(billPaymentPage.hasPayeeAccountInvalidFieldError());
        Assert.assertTrue(billPaymentPage.hasVerifyAccountInvalidFieldError());
        Assert.assertTrue(billPaymentPage.hasAmountInvalidErrorFieldError());
    }
}
