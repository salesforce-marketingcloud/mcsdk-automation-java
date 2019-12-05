# CampaignApi

All URIs are relative to *https://www.exacttargetapis.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCampaign**](CampaignApi.md#createCampaign) | **POST** /hub/v1/campaigns | createCampaign
[**deleteCampaignById**](CampaignApi.md#deleteCampaignById) | **DELETE** /hub/v1/campaigns/{id} | deleteCampaignById
[**getAllCampaigns**](CampaignApi.md#getAllCampaigns) | **GET** /hub/v1/campaigns | getAllCampaigns
[**getCampaignById**](CampaignApi.md#getCampaignById) | **GET** /hub/v1/campaigns/{id} | getCampaignById


<a name="createCampaign"></a>
# **createCampaign**
> Campaign createCampaign(body)

createCampaign

Creates a campaign.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.CampaignApi;


CampaignApi apiInstance = new CampaignApi();
Campaign body = new Campaign(); // Campaign | JSON Parameters
try {
    Campaign result = apiInstance.createCampaign(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignApi#createCampaign");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Campaign**](Campaign.md)| JSON Parameters |

### Return type

[**Campaign**](Campaign.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteCampaignById"></a>
# **deleteCampaignById**
> deleteCampaignById(id)

deleteCampaignById

Deletes a campaign.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.CampaignApi;


CampaignApi apiInstance = new CampaignApi();
String id = "id_example"; // String | The ID of the campaign to delete
try {
    apiInstance.deleteCampaignById(id);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignApi#deleteCampaignById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the campaign to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllCampaigns"></a>
# **getAllCampaigns**
> GetAllCampaignsResponse getAllCampaigns()

getAllCampaigns

Gets all campaigns.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.CampaignApi;


CampaignApi apiInstance = new CampaignApi();
try {
    GetAllCampaignsResponse result = apiInstance.getAllCampaigns();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignApi#getAllCampaigns");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetAllCampaignsResponse**](GetAllCampaignsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getCampaignById"></a>
# **getCampaignById**
> Campaign getCampaignById(id)

getCampaignById

Retrieves a campaign.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.CampaignApi;


CampaignApi apiInstance = new CampaignApi();
String id = "id_example"; // String | Campaign ID
try {
    Campaign result = apiInstance.getCampaignById(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CampaignApi#getCampaignById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Campaign ID |

### Return type

[**Campaign**](Campaign.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

