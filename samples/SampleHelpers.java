import com.github.salesforce.marketingcloud.javasdk.ApiException;
import com.github.salesforce.marketingcloud.javasdk.api.AssetApi;
import com.github.salesforce.marketingcloud.javasdk.model.*;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.util.UUID;

class SampleHelpers {

    private static Asset createEmailAsset() {
        final String customerKey = UUID.randomUUID().toString();              // it has be unique
        final String assetName = UUID.randomUUID().toString();                // it has be unique
        final String assetDescription = "EmailAsset created from automated Java SDK";

        Asset asset = new Asset();
        asset.setCustomerKey(customerKey);
        asset.setName(assetName);
        asset.setDescription(assetDescription);

        AssetType assetType = createAssetType();
        asset.setAssetType(assetType);

        JsonObject views = new JsonObject();
        JsonObject subjectLine = new JsonObject();
        JsonObject html = new JsonObject();

        subjectLine.addProperty("content", "Email generated from the Java SDK");
        html.addProperty("content", "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Welcome to SFMC Transactional Messaging</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <img src=\"https://image.slidesharecdn.com/scalingdevelopereffortswithsalesforcemarketingcloudpptxv4-180803183610/95/scaling-developer-efforts-with-salesforce-marketing-cloud-31-638.jpg?cb=1533321419\"\n" +
                "        alt=\"Let's Talk TM image\">\n" +
                "</body>\n" +
                "\n" +
                "</html>");

        views.add("subjectline", subjectLine);
        views.add("html", html);

        asset.setViews(views);

        return asset;
    }

    private static AssetType createAssetType() {
        final BigDecimal HTML_EMAIL_ASSET_TYPE_ID = BigDecimal.valueOf(208);
        final String ASSET_TYPE_NAME = "htmlemail";

        AssetType assetType = new AssetType();

        assetType.setId(HTML_EMAIL_ASSET_TYPE_ID);
        assetType.setName(ASSET_TYPE_NAME);
        assetType.setDisplayName(ASSET_TYPE_NAME);

        return assetType;
    }

    static EmailDefinition createEmailDefinitionObject(AssetApi assetApi) throws ApiException {

        /* Replace '<SUBSCRIBERS_LIST_KEY>' with the key of
        one of your subscribers lists or use 'All Subscribers' */
        final String subscribersListKey = "<SUBSCRIBERS_LIST_KEY>";

        Asset emailAsset = createEmailAsset();
        Asset createAssetResult = assetApi.createAsset(emailAsset);
        String customerKey = createAssetResult.getCustomerKey();

        EmailDefinitionContent content = new EmailDefinitionContent();
        content.setCustomerKey(customerKey);

        EmailDefinitionSubscriptions subscriptions = new EmailDefinitionSubscriptions();
        subscriptions.setList(subscribersListKey);

        EmailDefinition emailDefinition = new EmailDefinition();
        emailDefinition.setName(UUID.randomUUID().toString());
        emailDefinition.setDefinitionKey(UUID.randomUUID().toString());
        emailDefinition.setContent(content);
        emailDefinition.setSubscriptions(subscriptions);

        return emailDefinition;
    }
}
