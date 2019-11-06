package com.github.salesforce.marketingcloud.javasdk;

import com.github.salesforce.marketingcloud.javasdk.validation.ModelValidator;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ApiClientTest {
    RuntimeInformationProvider runtimeInformationProviderMock = mock(RuntimeInformationProvider.class);
    ModelValidator modelValidatorMock = mock(ModelValidator.class);

    @Test
    public void shouldGetRuntimeInformation() {
        new ApiClient(runtimeInformationProviderMock, modelValidatorMock);

        verify(runtimeInformationProviderMock, times(1)).getForUserAgentString();
    }

    @Test
    public void shouldValidateModelOnSerializeWhenTheContentTypeIsJson() throws ApiException {
        Object obj = new Object();

        new ApiClient(runtimeInformationProviderMock, modelValidatorMock)
                .serialize(obj, "application/json");

        verify(modelValidatorMock, times(1)).validate(obj);
    }
}
