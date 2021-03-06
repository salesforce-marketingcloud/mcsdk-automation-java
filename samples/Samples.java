import com.github.salesforce.marketingcloud.javasdk.ApiException;
import com.github.salesforce.marketingcloud.javasdk.api.AssetApi;
import com.github.salesforce.marketingcloud.javasdk.api.Client;
import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;
import com.github.salesforce.marketingcloud.javasdk.exception.EnvironmentVariableNotSetException;
import com.github.salesforce.marketingcloud.javasdk.model.*;

import java.util.Arrays;
import java.util.List;

class Samples {
    static void SendEmailToSingleRecipient() throws ApiException {

        // Replace '<CONTACT_KEY>' with a real subscriber key
        final String contactKey = "<CONTACT_KEY>";

        /* Replace the constructor parameters with your Marketing Cloud account credentials
         * Set <APPLICATION DATA-ACCESS PERMISSIONS> to null if you want to get an access token
         * with all your data-access permissions */

        Client client = new Client(
                "<AUTH_BASE_URL>",
                "<CLIENT_ID>",
                "<CLIENT_SECRET>",
                "<ACCOUNT_ID>",
                "<APPLICATION_DATA-ACCESS_PERMISSIONS>"
        );

        // Get the asset, transactional messaging API instances:
        AssetApi assetApi = client.getAssetApi();
        TransactionalMessagingApi transactionalMessagingApi = client.getTransactionalMessagingApi();

        // Create email send definition:
        EmailDefinition emailDefinition = SampleHelpers.createEmailDefinitionObject(assetApi);
        EmailDefinition createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);

        // Get email send definition:
        EmailDefinition getEmailDefinitionsResult = transactionalMessagingApi.getEmailDefinition(createEmailDefinitionResult.getDefinitionKey());

        // Update email send definition:
        UpdateEmailDefinitionRequest updatedDefinitionDescription = new UpdateEmailDefinitionRequest();
        updatedDefinitionDescription.setDescription("Updated email definition description");
        EmailDefinition partiallyUpdateEmailDefinitionResult = transactionalMessagingApi.partiallyUpdateEmailDefinition(getEmailDefinitionsResult.getDefinitionKey(), updatedDefinitionDescription);

        // Get email send definition:
        getEmailDefinitionsResult = transactionalMessagingApi.getEmailDefinition(partiallyUpdateEmailDefinitionResult.getDefinitionKey());

        // Send email to single recipient:
        String emailToSendToRecipientKey = getEmailDefinitionsResult.getDefinitionKey();

        Recipient recipient = new Recipient();
        recipient.setContactKey(contactKey);

        SendEmailToSingleRecipientRequest messageRequestBody = new SendEmailToSingleRecipientRequest();
        messageRequestBody.setDefinitionKey(emailToSendToRecipientKey);
        messageRequestBody.setRecipient(recipient);

        String recipientMessageKey = java.util.UUID.randomUUID().toString();
        transactionalMessagingApi.sendEmailToSingleRecipient(recipientMessageKey, messageRequestBody);

        // Get the send status of the email send:
        GetDefinitionSendStatusForRecipientResponse recipientSendStatus = transactionalMessagingApi.getEmailSendStatusForRecipient(recipientMessageKey);
    }

    static void SendEmailToMultipleRecipients() throws EnvironmentVariableNotSetException, ApiException {

        // Replace '<CONTACT1_KEY>' and '<CONTACT2_KEY>' with real subscriber keys
        final String contact1Key = "<CONTACT1_KEY>";
        final String contact2Key = "<CONTACT2_KEY>";

        // Environment variables instantiated client:
        Client client = new Client();

        // Get the asset, transactional messaging API instances:
        AssetApi assetApi = client.getAssetApi();
        TransactionalMessagingApi transactionalMessagingApi = client.getTransactionalMessagingApi();

        // Create email send definition:
        EmailDefinition emailDefinition = SampleHelpers.createEmailDefinitionObject(assetApi);
        EmailDefinition createEmailDefinitionResult = transactionalMessagingApi.createEmailDefinition(emailDefinition);

        Recipient recipient1 = new Recipient();
        recipient1.setContactKey(contact1Key);
        String recipient1MessageKey1 = java.util.UUID.randomUUID().toString();
        recipient1.setMessageKey(recipient1MessageKey1);

        Recipient recipient2 = new Recipient();
        recipient2.setContactKey(contact2Key);
        String recipient1MessageKey2 = java.util.UUID.randomUUID().toString();
        recipient2.setMessageKey(recipient1MessageKey2);

        List<Recipient> recipientsList = Arrays.asList(recipient1, recipient2);

        SendEmailToMultipleRecipientsRequest batchMessageRequestBody = new SendEmailToMultipleRecipientsRequest();
        batchMessageRequestBody.setDefinitionKey(createEmailDefinitionResult.getDefinitionKey());
        batchMessageRequestBody.setRecipients(recipientsList);

        transactionalMessagingApi.sendEmailToMultipleRecipients(batchMessageRequestBody);

        // Get the send status of the two email sends:
        GetDefinitionSendStatusForRecipientResponse recipient1SendStatus = transactionalMessagingApi.getEmailSendStatusForRecipient(recipient1MessageKey1);
        GetDefinitionSendStatusForRecipientResponse recipient2SendStatus = transactionalMessagingApi.getEmailSendStatusForRecipient(recipient1MessageKey2);
    }
}
