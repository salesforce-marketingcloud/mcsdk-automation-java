# AssetApi

All URIs are relative to *https://www.exacttargetapis.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAsset**](AssetApi.md#createAsset) | **POST** /asset/v1/content/assets | createAsset
[**deleteAssetById**](AssetApi.md#deleteAssetById) | **DELETE** /asset/v1/content/assets/{id} | deleteAssetById
[**getAssetById**](AssetApi.md#getAssetById) | **GET** /asset/v1/content/assets/{id} | getAssetById
[**partiallyUpdateAssetById**](AssetApi.md#partiallyUpdateAssetById) | **PATCH** /asset/v1/content/assets/{id} | partiallyUpdateAssetById


<a name="createAsset"></a>
# **createAsset**
> Asset createAsset(body)

createAsset

Creates a new asset.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.AssetApi;


AssetApi apiInstance = new AssetApi();
Asset body = new Asset(); // Asset | JSON Parameters
try {
    Asset result = apiInstance.createAsset(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AssetApi#createAsset");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Asset**](Asset.md)| JSON Parameters |

### Return type

[**Asset**](Asset.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteAssetById"></a>
# **deleteAssetById**
> deleteAssetById(id)

deleteAssetById

Deletes an asset.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.AssetApi;


AssetApi apiInstance = new AssetApi();
BigDecimal id = new BigDecimal(); // BigDecimal | The ID of the asset to delete
try {
    apiInstance.deleteAssetById(id);
} catch (ApiException e) {
    System.err.println("Exception when calling AssetApi#deleteAssetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **BigDecimal**| The ID of the asset to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAssetById"></a>
# **getAssetById**
> Asset getAssetById(id)

getAssetById

Gets an asset by ID.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.AssetApi;


AssetApi apiInstance = new AssetApi();
BigDecimal id = new BigDecimal(); // BigDecimal | The ID of the asset
try {
    Asset result = apiInstance.getAssetById(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AssetApi#getAssetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **BigDecimal**| The ID of the asset |

### Return type

[**Asset**](Asset.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="partiallyUpdateAssetById"></a>
# **partiallyUpdateAssetById**
> Asset partiallyUpdateAssetById(id, body)

partiallyUpdateAssetById

Updates part of an asset.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.AssetApi;


AssetApi apiInstance = new AssetApi();
BigDecimal id = new BigDecimal(); // BigDecimal | The ID of the asset to update
Asset body = new Asset(); // Asset | JSON Parameters
try {
    Asset result = apiInstance.partiallyUpdateAssetById(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AssetApi#partiallyUpdateAssetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **BigDecimal**| The ID of the asset to update |
 **body** | [**Asset**](Asset.md)| JSON Parameters |

### Return type

[**Asset**](Asset.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

