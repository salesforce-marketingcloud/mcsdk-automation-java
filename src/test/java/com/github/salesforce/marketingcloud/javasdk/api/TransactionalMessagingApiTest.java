/*
 * Marketing Cloud REST API
 * Marketing Cloud's REST API is our newest API. It supports multi-channel use cases, is much more lightweight and easy to use than our SOAP API, and is getting more comprehensive with every release.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: mc_sdk@salesforce.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-transactionalMessagingApi/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.github.salesforce.marketingcloud.javasdk.api;

import com.github.salesforce.marketingcloud.javasdk.ApiException;
import com.github.salesforce.marketingcloud.javasdk.exception.EnvironmentVariableNotSetException;
import com.github.salesforce.marketingcloud.javasdk.infrastructure.EnvVariableName;
import com.github.salesforce.marketingcloud.javasdk.infrastructure.EnvironmentConfigProvider;
import com.github.salesforce.marketingcloud.javasdk.model.*;
import com.google.gson.JsonObject;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * API tests for TransactionalMessagingApi
 */
public class TransactionalMessagingApiTest
{
    public static final String JOHN_DOE_GMAIL_COM = "johnDoe@gmail.com";
    public static final String JOHANNA_DOE_YAHOO_COM = "johannaDoe@yahoo.com";
    public static final BigDecimal HTML_EMAIL_ASSET_TYPE_ID = BigDecimal.valueOf(208);

    private final TransactionalMessagingApi transactionalMessagingApi;
    private final AssetApi assetApi;
    private final EnvironmentConfigProvider configProvider;

    public TransactionalMessagingApiTest() throws EnvironmentVariableNotSetException {
        this.transactionalMessagingApi = ClientFactory.createClient().getTransactionalMessagingApi();
        this.assetApi = ClientFactory.createClient().getAssetApi();
        this.configProvider = new EnvironmentConfigProvider();
    }

    /**
     * createEmailDefinition
     *
     * Creates the definition for an email.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createEmailDefinitionTest() throws ApiException {
        String emailDefinitionKey = null;

        try {
            CreateEmailDefinitionRequest emailDefinition = createEmailDefinitionObject();
            CreateEmailDefinitionRequest createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);
            emailDefinitionKey = createEmailDefinitionResult.getDefinitionKey();

            assertEquals(emailDefinition.getDefinitionKey(), createEmailDefinitionResult.getDefinitionKey());
            assertEquals(emailDefinition.getName(), createEmailDefinitionResult.getName());
            assertEquals(emailDefinition.getContent().getCustomerKey(), createEmailDefinitionResult.getContent().getCustomerKey());
        }
        finally {
            if(emailDefinitionKey != null){
                transactionalMessagingApi.deleteEmailDefinition(emailDefinitionKey);
            }
        }
    }

    /**
     * createSmsDefinition
     *
     * Creates the definition for an SMS.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createSmsDefinitionTest() throws ApiException, EnvironmentVariableNotSetException {
        String smsDefinitionKey = null;

        try {
            CreateSmsDefinitionRequest smsDefinition = createSmsDefinitionObject();
            CreateSmsDefinitionRequest createSmsDefinitionResult = transactionalMessagingApi.createSmsDefinition(smsDefinition);
            smsDefinitionKey = createSmsDefinitionResult.getDefinitionKey();

            assertEquals(smsDefinition.getDefinitionKey(), createSmsDefinitionResult.getDefinitionKey());
            assertEquals(smsDefinition.getName(), createSmsDefinitionResult.getName());
            assertEquals(smsDefinition.getSubscriptions().getShortCode(), createSmsDefinitionResult.getSubscriptions().getShortCode());
            assertEquals(smsDefinition.getSubscriptions().getCountryCode(), createSmsDefinitionResult.getSubscriptions().getCountryCode());
            assertEquals(smsDefinition.getContent(), createSmsDefinitionResult.getContent());
        }
        finally {
            if(smsDefinitionKey != null){
                transactionalMessagingApi.deleteSmsDefinition(smsDefinitionKey);
            }
        }
    }

    /**
     * deleteEmailDefinition
     *
     * Deletes an email definition. You can&#39;t restore a deleted definition. The deleted definition is archived, and a delete location of the definition key is provided in the response for reference. You can reuse a deleted definition key because the information associated with it is copied to a new unique identifier.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteEmailDefinitionTest() throws ApiException {
        CreateEmailDefinitionRequest emailDefinition = createEmailDefinitionObject();
        CreateEmailDefinitionRequest createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);
        String emailDefinitionToDeleteKey = createEmailDefinitionResult.getDefinitionKey();

        DeleteSendDefinitionResponse deleteEmailDefinitionResult = transactionalMessagingApi.deleteEmailDefinition(emailDefinitionToDeleteKey);

        Assert.assertNotNull(deleteEmailDefinitionResult.getRequestId());
        Assert.assertNotNull(deleteEmailDefinitionResult.getDeletedDefinitionKey());
        assertEquals("Success", deleteEmailDefinitionResult.getMessage());
    }

    /**
     * deleteEmailDefinition
     *
     * Deletes an email definition. You can&#39;t restore a deleted definition. The deleted definition is archived, and a delete location of the definition key is provided in the response for reference. You can reuse a deleted definition key because the information associated with it is copied to a new unique identifier.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deletingNonExistingEmailDefinitionShouldReturn404(){
        String emailDefinitionToDeleteKey = "NonExistingEmailDefinitionKey";

        try{
            transactionalMessagingApi.deleteEmailDefinition(emailDefinitionToDeleteKey);
        }
        catch (ApiException e){
            assertEquals(404, e.getCode());
        }
    }

    /**
     * deleteQueuedMessagesForEmailDefinition
     *
     * Deletes the queue for an email definition. The email definition must be in inactive status.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteQueuedMessagesForEmailDefinitionTest() throws ApiException {
        String emailDefinitionQueToDeleteKey = null;

        try {
            CreateEmailDefinitionRequest emailDefinition = createEmailDefinitionObject();
            emailDefinition.setStatus("inactive");

            CreateEmailDefinitionRequest createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);
            emailDefinitionQueToDeleteKey = createEmailDefinitionResult.getDefinitionKey();

            DeleteQueuedMessagesForSendDefinitionResponse deleteQueuedMessagesForEmailDefinitionResult = transactionalMessagingApi.deleteQueuedMessagesForEmailDefinition(emailDefinitionQueToDeleteKey);

            Assert.assertNotNull(deleteQueuedMessagesForEmailDefinitionResult.getRequestId());
        }
        finally {
            if(emailDefinitionQueToDeleteKey != null){
                transactionalMessagingApi.deleteEmailDefinition(emailDefinitionQueToDeleteKey);
            }
        }
    }

    /**
     * deleteSmsDefinition
     *
     * Deletes an sms definition. You can&#39;t restore a deleted definition. The deleted definition is archived, and a delete location of the definition key is provided in the response for reference. You can reuse a deleted definition key because the information associated with it is copied to a new unique identifier.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteSmsDefinitionTest() throws ApiException, EnvironmentVariableNotSetException {
        CreateSmsDefinitionRequest smsDefinition = createSmsDefinitionObject();
        CreateSmsDefinitionRequest createSmsDefinitionResult = transactionalMessagingApi.createSmsDefinition(smsDefinition);
        String smsDefinitionToDeleteKey = createSmsDefinitionResult.getDefinitionKey();

        DeleteSendDefinitionResponse deleteSmsDefinitionResult = transactionalMessagingApi.deleteSmsDefinition(smsDefinitionToDeleteKey);

        Assert.assertNotNull(deleteSmsDefinitionResult.getRequestId());
        Assert.assertNotNull(deleteSmsDefinitionResult.getDeletedDefinitionKey());
        assertEquals("Success", deleteSmsDefinitionResult.getMessage());
    }

    /**
     * deleteSmsDefinition
     *
     * Deletes an sms definition. You can&#39;t restore a deleted definition. The deleted definition is archived, and a delete location of the definition key is provided in the response for reference. You can reuse a deleted definition key because the information associated with it is copied to a new unique identifier.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deletingNonExistingSmsDefinitionShouldReturn404(){
        String smsDefinitionToDeleteKey = "NonExistingSmsDefinitionKey";

        try{
            transactionalMessagingApi.deleteSmsDefinition(smsDefinitionToDeleteKey);
        }
        catch (ApiException e){
            assertEquals(404, e.getCode());
        }
    }

    /**
     * deleteQueuedMessagesForSmsDefinition
     *
     * Deletes the queue for a SMS definition. The SMS definition must be in inactive status.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteQueuedMessagesForSmsDefinitionTest() throws ApiException, EnvironmentVariableNotSetException {
        String smsDefinitionQueToDeleteKey = null;

        try {
            CreateSmsDefinitionRequest smsDefinition = createSmsDefinitionObject();
            smsDefinition.setStatus("inactive");

            CreateSmsDefinitionRequest createSmsDefinitionResult = transactionalMessagingApi.createSmsDefinition(smsDefinition);
            smsDefinitionQueToDeleteKey = createSmsDefinitionResult.getDefinitionKey();

            DeleteQueuedMessagesForSendDefinitionResponse deleteQueuedMessagesForSmsDefinitionResult = transactionalMessagingApi.deleteQueuedMessagesForSmsDefinition(smsDefinitionQueToDeleteKey);

            Assert.assertNotNull(deleteQueuedMessagesForSmsDefinitionResult.getRequestId());
        }
        finally {
            if(smsDefinitionQueToDeleteKey != null){
                transactionalMessagingApi.deleteSmsDefinition(smsDefinitionQueToDeleteKey);
            }
        }
    }

    /**
     * getEmailDefinition
     *
     * Gets email definition configuration details for a definition key.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEmailDefinitionTest() throws ApiException {
        String emailDefinitionToRetrieveKey = null;

        try {
            CreateEmailDefinitionRequest emailDefinition = createEmailDefinitionObject();
            CreateEmailDefinitionRequest createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);
            emailDefinitionToRetrieveKey = createEmailDefinitionResult.getDefinitionKey();

            CreateEmailDefinitionRequest getEmailDefinitionsResult = transactionalMessagingApi.getEmailDefinition(emailDefinitionToRetrieveKey);

            assertEquals(emailDefinition.getDefinitionKey(), getEmailDefinitionsResult.getDefinitionKey());
            assertEquals(emailDefinition.getName(), getEmailDefinitionsResult.getName());
            assertEquals(emailDefinition.getContent().getCustomerKey(), getEmailDefinitionsResult.getContent().getCustomerKey());
        }
        finally {
            if(emailDefinitionToRetrieveKey != null){
                transactionalMessagingApi.deleteEmailDefinition(emailDefinitionToRetrieveKey);
            }
        }
    }

    /**
     * getEmailDefinitions
     *
     * Gets a list of email definitions.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEmailDefinitionsTest() throws ApiException {
        String status = null, orderBy = null;
        BigDecimal pageSize = null, page = null;

        GetEmailDefinitionsResponse getEmailDefinitionsResult = transactionalMessagingApi.getEmailDefinitions(status, pageSize, page, orderBy);

        Assert.assertNotNull(getEmailDefinitionsResult.getRequestId());
        Assert.assertNotNull(getEmailDefinitionsResult.getDefinitions());
        Assert.assertNotNull(getEmailDefinitionsResult.getCount());
        Assert.assertNotNull(getEmailDefinitionsResult.getPage());
        Assert.assertNotNull(getEmailDefinitionsResult.getPageSize());
    }

    /**
     * getEmailSendStatusForRecipient
     *
     * Gets the send status for a message. Because this route is rate-limited, use it for infrequent verification of a messageKey. To collect send status at scale, subscribe to transactional send events using the Event Notification Service.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEmailSendStatusForRecipientTest() throws ApiException {
        String emailToSendToRecipientKey = null;

        try {
            CreateEmailDefinitionRequest emailDefinition = createEmailDefinitionObject();
            CreateEmailDefinitionRequest createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);
            emailToSendToRecipientKey = createEmailDefinitionResult.getDefinitionKey();

            Recipient recipient = new Recipient();
            recipient.setContactKey(JOHN_DOE_GMAIL_COM);

            String messageKey = java.util.UUID.randomUUID().toString();

            SendEmailToSingleRecipientRequest messageRequestBody = new SendEmailToSingleRecipientRequest();
            messageRequestBody.setDefinitionKey(emailToSendToRecipientKey);
            messageRequestBody.setRecipient(recipient);

            transactionalMessagingApi.sendEmailToSingleRecipient(messageKey, messageRequestBody);

            GetDefinitionSendStatusForRecipientResponse getEmailSendStatusForRecipientResult = transactionalMessagingApi.getEmailSendStatusForRecipient(messageKey);

            Assert.assertNotNull(getEmailSendStatusForRecipientResult.getRequestId());
            Assert.assertNotNull(getEmailSendStatusForRecipientResult.getTimestamp());

            List<String> eventCategoryTypes = Arrays.asList("TransactionalSendEvents.EmailSent", "TransactionalSendEvents.EmailQueued", "TransactionalSendEvents.EmailNotSent");

            assertThat(eventCategoryTypes, org.hamcrest.Matchers.hasItem(getEmailSendStatusForRecipientResult.getEventCategoryType()));
        }
        finally {
            if(emailToSendToRecipientKey != null){
                transactionalMessagingApi.deleteEmailDefinition(emailToSendToRecipientKey);
            }
        }
    }

    /**
     * getEmailsNotSentToRecipients
     *
     * Gets a paginated list of messages that were not sent, ordered from oldest to newest.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEmailsNotSentToRecipientsTest() throws ApiException {
        GetDefinitionsNotSentToRecipientsResponse getEmailsNotSentToRecipientsResponse = transactionalMessagingApi.getEmailsNotSentToRecipients("notSent", null, null);

        Assert.assertNotNull(getEmailsNotSentToRecipientsResponse.getRequestId());
        Assert.assertNotNull(getEmailsNotSentToRecipientsResponse.getLastEventID());
        Assert.assertNotNull(getEmailsNotSentToRecipientsResponse.getMessages());
        Assert.assertNotNull(getEmailsNotSentToRecipientsResponse.getCount());
        Assert.assertNotNull(getEmailsNotSentToRecipientsResponse.getPageSize());
    }

    /**
     * getQueueMetricsForEmailDefinition
     *
     * Gets metrics for the messages of an email definition. Applies to messages that are accepted but not yet processed.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getQueueMetricsForEmailDefinitionTest() throws ApiException {
        String emailDefinitionQueueMetricsToReceiveKey = null;

        try {
            CreateEmailDefinitionRequest emailDefinition = createEmailDefinitionObject();
            CreateEmailDefinitionRequest createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);
            emailDefinitionQueueMetricsToReceiveKey = createEmailDefinitionResult.getDefinitionKey();

            GetQueueMetricsForSendDefinitionResponse getQueueMetricsForEmailDefinitionResult = transactionalMessagingApi.getQueueMetricsForEmailDefinition(emailDefinitionQueueMetricsToReceiveKey);

            Assert.assertNotNull(getQueueMetricsForEmailDefinitionResult.getRequestId());
            Assert.assertNotNull(getQueueMetricsForEmailDefinitionResult.getCount());
            Assert.assertNotNull(getQueueMetricsForEmailDefinitionResult.getAgeSeconds());
        }
        finally {
            if(emailDefinitionQueueMetricsToReceiveKey != null){
                transactionalMessagingApi.deleteEmailDefinition(emailDefinitionQueueMetricsToReceiveKey);
            }
        }
    }

    /**
     * getQueueMetricsForSmsDefinition
     *
     * Gets metrics for the messages of a SMS definition. Applies to messages that are accepted but not yet processed.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getQueueMetricsForSmsDefinitionTest() throws ApiException, EnvironmentVariableNotSetException {
        String smsDefinitionQueueMetricsToReceiveKey = null;

        try {
            CreateSmsDefinitionRequest smsDefinition = createSmsDefinitionObject();
            CreateSmsDefinitionRequest createSmsDefinitionResult = transactionalMessagingApi.createSmsDefinition(smsDefinition);
            smsDefinitionQueueMetricsToReceiveKey = createSmsDefinitionResult.getDefinitionKey();

            GetQueueMetricsForSendDefinitionResponse getQueueMetricsForSmsDefinitionResult = transactionalMessagingApi.getQueueMetricsForSmsDefinition(smsDefinitionQueueMetricsToReceiveKey);

            Assert.assertNotNull(getQueueMetricsForSmsDefinitionResult.getRequestId());
            Assert.assertNotNull(getQueueMetricsForSmsDefinitionResult.getCount());
            Assert.assertNotNull(getQueueMetricsForSmsDefinitionResult.getAgeSeconds());
        }
        finally {
            if(smsDefinitionQueueMetricsToReceiveKey != null){
                transactionalMessagingApi.deleteSmsDefinition(smsDefinitionQueueMetricsToReceiveKey);
            }
        }
    }

    /**
     * getSMSsNotSentToRecipients
     *
     * Gets a paginated list of messages that were not sent, ordered from oldest to newest.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSMSsNotSentToRecipientsTest() throws ApiException {
        GetDefinitionsNotSentToRecipientsResponse getSMSsNotSentToRecipientsResponse = transactionalMessagingApi.getSMSsNotSentToRecipients("notSent", null, null);

        Assert.assertNotNull(getSMSsNotSentToRecipientsResponse.getRequestId());
        Assert.assertNotNull(getSMSsNotSentToRecipientsResponse.getLastEventID());
        Assert.assertNotNull(getSMSsNotSentToRecipientsResponse.getMessages());
        Assert.assertNotNull(getSMSsNotSentToRecipientsResponse.getCount());
        Assert.assertNotNull(getSMSsNotSentToRecipientsResponse.getPageSize());
    }

    /**
     * getSmsDefinition
     *
     * Gets SMS definition configuration details for a definition key.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSmsDefinitionTest() throws ApiException, EnvironmentVariableNotSetException {
        String smsDefinitionToRetrieveKey = null;

        try {
            CreateSmsDefinitionRequest smsDefinition = createSmsDefinitionObject();
            CreateSmsDefinitionRequest createSmsDefinitionResult = transactionalMessagingApi.createSmsDefinition(smsDefinition);
            smsDefinitionToRetrieveKey = createSmsDefinitionResult.getDefinitionKey();

            CreateSmsDefinitionRequest getSmsDefinitionResult = transactionalMessagingApi.getSmsDefinition(smsDefinitionToRetrieveKey);

            assertEquals(smsDefinition.getDefinitionKey(), getSmsDefinitionResult.getDefinitionKey());
            assertEquals(smsDefinition.getName(), getSmsDefinitionResult.getName());
            assertEquals(smsDefinition.getSubscriptions().getShortCode(), getSmsDefinitionResult.getSubscriptions().getShortCode());
            assertEquals(smsDefinition.getSubscriptions().getCountryCode(), getSmsDefinitionResult.getSubscriptions().getCountryCode());
            assertEquals(smsDefinition.getContent(), getSmsDefinitionResult.getContent());
        }
        finally {
            if(smsDefinitionToRetrieveKey != null){
                transactionalMessagingApi.deleteSmsDefinition(smsDefinitionToRetrieveKey);
            }
        }
    }

    /**
     * getSmsDefinitions
     *
     * Gets a list of SMS definitions.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSmsDefinitionsTest() throws ApiException {
        String status = null, orderBy = null;
        BigDecimal pageSize = null, page = null;

        GetSmsDefinitionsResponse getSmsDefinitionsResult = transactionalMessagingApi.getSmsDefinitions(status, pageSize, page, orderBy);

        Assert.assertNotNull(getSmsDefinitionsResult.getRequestId());
        Assert.assertNotNull(getSmsDefinitionsResult.getDefinitions());
        Assert.assertNotNull(getSmsDefinitionsResult.getCount());
        Assert.assertNotNull(getSmsDefinitionsResult.getPage());
        Assert.assertNotNull(getSmsDefinitionsResult.getPageSize());
    }

    /**
     * getSmsSendStatusForRecipient
     *
     * Gets the send status for a message. Because this route is rate-limited, use it for infrequent verification of a messageKey. To collect send status at scale, subscribe to transactional send events using the Event Notification Service.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSmsSendStatusForRecipientTest() throws ApiException, EnvironmentVariableNotSetException {
        String smsToSendToRecipientKey = null;

        try {
            CreateSmsDefinitionRequest smsDefinition = createSmsDefinitionObject();
            CreateSmsDefinitionRequest createSmsDefinitionResult = transactionalMessagingApi.createSmsDefinition(smsDefinition);
            smsToSendToRecipientKey = createSmsDefinitionResult.getDefinitionKey();

            Recipient recipient = new Recipient();
            recipient.setContactKey(JOHN_DOE_GMAIL_COM);

            String messageKey = java.util.UUID.randomUUID().toString();

            SendSmsToSingleRecipientRequest messageRequestBody = new SendSmsToSingleRecipientRequest();
            messageRequestBody.setDefinitionKey(smsToSendToRecipientKey);
            messageRequestBody.setRecipient(recipient);

            transactionalMessagingApi.sendSmsToSingleRecipient(messageKey, messageRequestBody);

            GetDefinitionSendStatusForRecipientResponse getSmsSendStatusForRecipientResult = transactionalMessagingApi.getSmsSendStatusForRecipient(messageKey);

            Assert.assertNotNull(getSmsSendStatusForRecipientResult.getRequestId());
            Assert.assertNotNull(getSmsSendStatusForRecipientResult.getTimestamp());

            List<String> eventCategoryTypes = Arrays.asList("TransactionalSendEvents.SMSSent", "TransactionalSendEvents.SMSQueued", "TransactionalSendEvents.SMSNotSent");

            assertThat(eventCategoryTypes, Matchers.hasItem(getSmsSendStatusForRecipientResult.getEventCategoryType()));
        }
        finally {
            if(smsToSendToRecipientKey != null){
                transactionalMessagingApi.deleteSmsDefinition(smsToSendToRecipientKey);
            }
        }
    }

    /**
     * partiallyUpdateEmailDefinition
     *
     * Updates a specific email definition.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void partiallyUpdateEmailDefinitionTest() throws ApiException {
        String emailDefinitionToPartiallyUpdateKey = null;

        try {
            CreateEmailDefinitionRequest emailDefinition = createEmailDefinitionObject();
            CreateEmailDefinitionRequest createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);
            emailDefinitionToPartiallyUpdateKey = createEmailDefinitionResult.getDefinitionKey();

            UpdateEmailDefinitionRequest updatedDefinitionDescription = new UpdateEmailDefinitionRequest();
            updatedDefinitionDescription.setDescription("Updated email definition description");
            CreateEmailDefinitionRequest partiallyUpdateEmailDefinitionResult = transactionalMessagingApi.partiallyUpdateEmailDefinition(emailDefinitionToPartiallyUpdateKey, updatedDefinitionDescription);

            assertEquals(updatedDefinitionDescription.getDescription(), partiallyUpdateEmailDefinitionResult.getDescription());

            assertEquals(emailDefinition.getDefinitionKey(), partiallyUpdateEmailDefinitionResult.getDefinitionKey());
            assertEquals(emailDefinition.getName(), partiallyUpdateEmailDefinitionResult.getName());
            assertEquals(emailDefinition.getContent().getCustomerKey(), partiallyUpdateEmailDefinitionResult.getContent().getCustomerKey());
        }
        finally {
            if(emailDefinitionToPartiallyUpdateKey != null){
                transactionalMessagingApi.deleteEmailDefinition(emailDefinitionToPartiallyUpdateKey);
            }
        }
    }

    /**
     * partiallyUpdateSmsDefinition
     *
     * Updates a specific SMS definition.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void partiallyUpdateSmsDefinitionTest() throws ApiException, EnvironmentVariableNotSetException {
        String smsDefinitionToPartiallyUpdateKey = null;

        try {
            CreateSmsDefinitionRequest smsDefinition = createSmsDefinitionObject();
            CreateSmsDefinitionRequest createSmsDefinitionResult = transactionalMessagingApi.createSmsDefinition(smsDefinition);
            smsDefinitionToPartiallyUpdateKey = createSmsDefinitionResult.getDefinitionKey();

            UpdateSmsDefinitionRequest updatedDefinitionDescription = new UpdateSmsDefinitionRequest();
            updatedDefinitionDescription.setDescription("Updated SMS definition description");
            CreateSmsDefinitionRequest partiallyUpdateSmsDefinitionResult = transactionalMessagingApi.partiallyUpdateSmsDefinition(smsDefinitionToPartiallyUpdateKey, updatedDefinitionDescription);

            assertEquals(updatedDefinitionDescription.getDescription(), partiallyUpdateSmsDefinitionResult.getDescription());

            assertEquals(smsDefinition.getDefinitionKey(), partiallyUpdateSmsDefinitionResult.getDefinitionKey());
            assertEquals(smsDefinition.getName(), partiallyUpdateSmsDefinitionResult.getName());
            assertEquals(smsDefinition.getContent(), partiallyUpdateSmsDefinitionResult.getContent());
            assertEquals(smsDefinition.getSubscriptions().getShortCode(), partiallyUpdateSmsDefinitionResult.getSubscriptions().getShortCode());
            assertEquals(smsDefinition.getSubscriptions().getCountryCode(), partiallyUpdateSmsDefinitionResult.getSubscriptions().getCountryCode());
        }
        finally {
            if(smsDefinitionToPartiallyUpdateKey != null){
                transactionalMessagingApi.deleteSmsDefinition(smsDefinitionToPartiallyUpdateKey);
            }
        }
    }

    /**
     * sendEmailToMultipleRecipients
     *
     * Sends a message to multiple recipients using an email definition. You can provide a messageKey in the request; otherwise, the messageKey is automatically generated in the response.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sendEmailToMultipleRecipientsTest() throws ApiException {
        String emailToSendToRecipientsKey = null;

        try {
            CreateEmailDefinitionRequest emailDefinition = createEmailDefinitionObject();
            CreateEmailDefinitionRequest createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);
            emailToSendToRecipientsKey = createEmailDefinitionResult.getDefinitionKey();

            Recipient recipient1 = new Recipient();
            recipient1.setContactKey(JOHN_DOE_GMAIL_COM);

            Recipient recipient2 = new Recipient();
            recipient2.setContactKey(JOHANNA_DOE_YAHOO_COM);

            List<Recipient> recipientsList = Arrays.asList(recipient1, recipient2);

            SendEmailToMultipleRecipientsRequest batchMessageRequestBody = new SendEmailToMultipleRecipientsRequest();
            batchMessageRequestBody.setDefinitionKey(emailToSendToRecipientsKey);
            batchMessageRequestBody.setRecipients(recipientsList);

            SendDefinitionToMultipleRecipientsResponse sendEmailToMultipleRecipientsResult = transactionalMessagingApi.sendEmailToMultipleRecipients(batchMessageRequestBody);

            Assert.assertNotNull(sendEmailToMultipleRecipientsResult.getRequestId());
            Assert.assertNotNull(sendEmailToMultipleRecipientsResult.getErrorcode());
            Assert.assertNotNull(sendEmailToMultipleRecipientsResult.getResponses());
        }
        finally {
            if(emailToSendToRecipientsKey != null){
                transactionalMessagingApi.deleteEmailDefinition(emailToSendToRecipientsKey);
            }
        }
    }

    /**
     * sendEmailToSingleRecipient
     *
     * Sends a message to a single recipient via an email definition using a messageKey path parameter.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sendEmailToSingleRecipientTest() throws ApiException {
        String emailToSendToRecipientKey = null;

        try {
            CreateEmailDefinitionRequest emailDefinition = createEmailDefinitionObject();
            CreateEmailDefinitionRequest createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);
            emailToSendToRecipientKey = createEmailDefinitionResult.getDefinitionKey();

            Recipient recipient = new Recipient();
            recipient.setContactKey(JOHN_DOE_GMAIL_COM);

            String messageKey = java.util.UUID.randomUUID().toString();

            SendEmailToSingleRecipientRequest messageRequestBody = new SendEmailToSingleRecipientRequest();
            messageRequestBody.setDefinitionKey(emailToSendToRecipientKey);
            messageRequestBody.setRecipient(recipient);

            SendDefinitionToSingleRecipientResponse sendEmailToSingleRecipientResult = transactionalMessagingApi.sendEmailToSingleRecipient(messageKey, messageRequestBody);

            Assert.assertNotNull(sendEmailToSingleRecipientResult.getRequestId());
            Assert.assertNotNull(sendEmailToSingleRecipientResult.getErrorcode());
            Assert.assertNotNull(sendEmailToSingleRecipientResult.getResponses());
        }
        finally {
            if(emailToSendToRecipientKey != null){
                transactionalMessagingApi.deleteEmailDefinition(emailToSendToRecipientKey);
            }
        }
    }

    /**
     * sendSmsToMultipleRecipients
     *
     * Sends a message to multiple recipients using an email definition. You can provide a messageKey in the request; otherwise, the messageKey is automatically generated in the response.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sendSmsToMultipleRecipientsTest() throws ApiException, EnvironmentVariableNotSetException {
        String smsToSendToRecipientsKey = null;

        try {
            CreateSmsDefinitionRequest smsDefinition = createSmsDefinitionObject();
            CreateSmsDefinitionRequest createSmsDefinitionResult = transactionalMessagingApi.createSmsDefinition(smsDefinition);
            smsToSendToRecipientsKey = createSmsDefinitionResult.getDefinitionKey();

            Recipient recipient1 = new Recipient();
            recipient1.setContactKey(JOHN_DOE_GMAIL_COM);

            Recipient recipient2 = new Recipient();
            recipient2.setContactKey(JOHANNA_DOE_YAHOO_COM);

            List<Recipient> recipientsList = Arrays.asList(recipient1, recipient2);

            SendSmsToMultipleRecipientsRequest batchMessageRequestBody = new SendSmsToMultipleRecipientsRequest();
            batchMessageRequestBody.setDefinitionKey(smsToSendToRecipientsKey);
            batchMessageRequestBody.setRecipients(recipientsList);

            SendDefinitionToMultipleRecipientsResponse sendSmsToMultipleRecipientsResult = transactionalMessagingApi.sendSmsToMultipleRecipients(batchMessageRequestBody);

            Assert.assertNotNull(sendSmsToMultipleRecipientsResult.getRequestId());
            Assert.assertNotNull(sendSmsToMultipleRecipientsResult.getErrorcode());
            Assert.assertNotNull(sendSmsToMultipleRecipientsResult.getResponses());
        }
        finally {
            if(smsToSendToRecipientsKey != null){
                transactionalMessagingApi.deleteSmsDefinition(smsToSendToRecipientsKey);
            }
        }
    }

    /**
     * sendSmsToSingleRecipient
     *
     * Sends a message to a single recipient via a SMS definition using a messageKey path parameter.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sendSmsToSingleRecipientTest() throws ApiException, EnvironmentVariableNotSetException {
        String smsToSendToRecipientKey = null;

        try {
            CreateSmsDefinitionRequest smsDefinition = createSmsDefinitionObject();
            CreateSmsDefinitionRequest createSmsDefinitionResult = transactionalMessagingApi.createSmsDefinition(smsDefinition);
            smsToSendToRecipientKey = createSmsDefinitionResult.getDefinitionKey();

            Recipient recipient = new Recipient();
            recipient.setContactKey(JOHN_DOE_GMAIL_COM);

            String messageKey = java.util.UUID.randomUUID().toString();

            SendSmsToSingleRecipientRequest messageRequestBody = new SendSmsToSingleRecipientRequest();
            messageRequestBody.setDefinitionKey(smsToSendToRecipientKey);
            messageRequestBody.setRecipient(recipient);

            SendDefinitionToSingleRecipientResponse sendSmsToSingleRecipientResult = transactionalMessagingApi.sendSmsToSingleRecipient(messageKey, messageRequestBody);

            Assert.assertNotNull(sendSmsToSingleRecipientResult.getRequestId());
            Assert.assertNotNull(sendSmsToSingleRecipientResult.getErrorcode());
            Assert.assertNotNull(sendSmsToSingleRecipientResult.getResponses());
        }
        finally {
            if(smsToSendToRecipientKey != null){
                transactionalMessagingApi.deleteSmsDefinition(smsToSendToRecipientKey);
            }
        }
    }

    private CreateSmsDefinitionRequest createSmsDefinitionObject() throws EnvironmentVariableNotSetException {
        CreateSmsDefinitionSubscriptions subscriptions = new CreateSmsDefinitionSubscriptions();
        subscriptions.setShortCode(configProvider.get(EnvVariableName.SHORT_CODE));
        subscriptions.setCountryCode("US");
        subscriptions.setKeyword(configProvider.get(EnvVariableName.KEYWORD));

        CreateSmsDefinitionContent content = new CreateSmsDefinitionContent();
        content.setMessage("Content message");

        CreateSmsDefinitionRequest smsDefinition = new CreateSmsDefinitionRequest();
        smsDefinition.setDefinitionKey(UUID.randomUUID().toString());
        smsDefinition.setName(UUID.randomUUID().toString());
        smsDefinition.setContent(content);
        smsDefinition.setSubscriptions(subscriptions);

        return smsDefinition;
    }

    private CreateEmailDefinitionRequest createEmailDefinitionObject() throws ApiException {
        Asset emailAsset = createAsset();

        Asset createAssetResult = assetApi.createAsset(emailAsset);
        String customerKey = createAssetResult.getCustomerKey();

        CreateEmailDefinitionContent content = new CreateEmailDefinitionContent();
        content.setCustomerKey(customerKey);

        CreateEmailDefinitionSubscriptions subscriptions = new CreateEmailDefinitionSubscriptions();
        subscriptions.setList("All Subscribers");

        CreateEmailDefinitionRequest emailDefinition = new CreateEmailDefinitionRequest();
        emailDefinition.setName(UUID.randomUUID().toString());
        emailDefinition.setDefinitionKey(UUID.randomUUID().toString());
        emailDefinition.setContent(content);
        emailDefinition.setSubscriptions(subscriptions);

        return emailDefinition;
    }

    private Asset createAsset() {
        Asset asset = new Asset();
        AssetType assetType = createAssetType();

        asset.setCustomerKey(java.util.UUID.randomUUID().toString());
        asset.setName("Asset " + java.util.UUID.randomUUID().toString());
        asset.setDescription("Asset from Automated Java SDK");
        asset.setAssetType(assetType);

        JsonObject views = new JsonObject();
        JsonObject subjectLine = new JsonObject();

        subjectLine.addProperty("content", "New TS Subject Line");
        views.add("subjectline", subjectLine);

        asset.setViews(views);

        return asset;
    }

    private AssetType createAssetType(){
        AssetType assetType = new AssetType();

        assetType.setId(HTML_EMAIL_ASSET_TYPE_ID);
        assetType.setName("htmlemail");
        assetType.setDisplayName("htmlemail");

        return assetType;
    }
}
