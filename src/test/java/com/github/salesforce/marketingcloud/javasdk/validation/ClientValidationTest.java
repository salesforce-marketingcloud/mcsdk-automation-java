package com.github.salesforce.marketingcloud.javasdk.validation;

import com.github.salesforce.marketingcloud.javasdk.ApiException;
import com.github.salesforce.marketingcloud.javasdk.BeanValidationException;
import com.github.salesforce.marketingcloud.javasdk.api.CampaignApi;
import com.github.salesforce.marketingcloud.javasdk.api.ClientFactory;
import com.github.salesforce.marketingcloud.javasdk.exception.EnvironmentVariableNotSetException;
import com.github.salesforce.marketingcloud.javasdk.model.Campaign;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class ClientValidationTest {
    @Test
    public void shouldValidateAllRequiredFields() throws ApiException, EnvironmentVariableNotSetException {
        try {
            Campaign c = new Campaign();
            CampaignApi campaignApi = ClientFactory.createClient().getCampaignApi();
            campaignApi.createCampaign(c);
            Assert.fail("BeanValidationException should be thrown");
        }
        catch(BeanValidationException ex)
        {
            assertThat(ex.getMessage(), containsString("campaignCode must not be null"));
            assertThat(ex.getMessage(), containsString("name must not be null"));
            assertThat(ex.getMessage(), containsString("description must not be null"));
            assertThat(ex.getMessage(), containsString("color must not be null"));
        }
    }

    @Test
    public void shouldValidateMaxLengthOfField() throws ApiException, EnvironmentVariableNotSetException {
        try {
            Campaign c = new Campaign();
            c.setCampaignCode("This a string that contains more than 36 characters");
            CampaignApi campaignApi = ClientFactory.createClient().getCampaignApi();
            campaignApi.createCampaign(c);
            Assert.fail("BeanValidationException should be thrown");
        }
        catch(BeanValidationException ex)
        {
            assertThat(ex.getMessage(), containsString("campaignCode size must be between 0 and 36"));
        }
    }

    @Test
    public void shouldValidateMethodParams() throws ApiException, EnvironmentVariableNotSetException {
        try {
            Campaign c = new Campaign();
            CampaignApi campaignApi = ClientFactory.createClient().getCampaignApi();
            campaignApi.getCampaignById(c.getId());
            Assert.fail("BeanValidationException should be thrown");
        }
        catch (BeanValidationException ex)
        {
            assertThat(ex.getMessage(), containsString("arg0 must not be null"));
        }
    }
}