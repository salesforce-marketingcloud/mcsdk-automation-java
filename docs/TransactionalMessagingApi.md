# TransactionalMessagingApi

All URIs are relative to *https://www.exacttargetapis.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEmailDefinition**](TransactionalMessagingApi.md#createEmailDefinition) | **POST** /messaging/v1/email/definitions/ | createEmailDefinition
[**createSmsDefinition**](TransactionalMessagingApi.md#createSmsDefinition) | **POST** /messaging/v1/sms/definitions | createSmsDefinition
[**deleteEmailDefinition**](TransactionalMessagingApi.md#deleteEmailDefinition) | **DELETE** /messaging/v1/email/definitions/{definitionKey} | deleteEmailDefinition
[**deleteQueuedMessagesForEmailDefinition**](TransactionalMessagingApi.md#deleteQueuedMessagesForEmailDefinition) | **DELETE** /messaging/v1/email/definitions/{definitionKey}/queue | deleteQueuedMessagesForEmailDefinition
[**deleteQueuedMessagesForSmsDefinition**](TransactionalMessagingApi.md#deleteQueuedMessagesForSmsDefinition) | **DELETE** /messaging/v1/sms/definitions/{definitionKey}/queue | deleteQueuedMessagesForSmsDefinition
[**deleteSmsDefinition**](TransactionalMessagingApi.md#deleteSmsDefinition) | **DELETE** /messaging/v1/sms/definitions/{definitionKey} | deleteSmsDefinition
[**getEmailDefinition**](TransactionalMessagingApi.md#getEmailDefinition) | **GET** /messaging/v1/email/definitions/{definitionKey} | getEmailDefinition
[**getEmailDefinitions**](TransactionalMessagingApi.md#getEmailDefinitions) | **GET** /messaging/v1/email/definitions/ | getEmailDefinitions
[**getEmailSendStatusForRecipient**](TransactionalMessagingApi.md#getEmailSendStatusForRecipient) | **GET** /messaging/v1/email/messages/{messageKey} | getEmailSendStatusForRecipient
[**getEmailsNotSentToRecipients**](TransactionalMessagingApi.md#getEmailsNotSentToRecipients) | **GET** /messaging/v1/email/messages/ | getEmailsNotSentToRecipients
[**getQueueMetricsForEmailDefinition**](TransactionalMessagingApi.md#getQueueMetricsForEmailDefinition) | **GET** /messaging/v1/email/definitions/{definitionKey}/queue | getQueueMetricsForEmailDefinition
[**getQueueMetricsForSmsDefinition**](TransactionalMessagingApi.md#getQueueMetricsForSmsDefinition) | **GET** /messaging/v1/sms/definitions/{definitionKey}/queue | getQueueMetricsForSmsDefinition
[**getSMSsNotSentToRecipients**](TransactionalMessagingApi.md#getSMSsNotSentToRecipients) | **GET** /messaging/v1/sms/messages/ | getSMSsNotSentToRecipients
[**getSmsDefinition**](TransactionalMessagingApi.md#getSmsDefinition) | **GET** /messaging/v1/sms/definitions/{definitionKey} | getSmsDefinition
[**getSmsDefinitions**](TransactionalMessagingApi.md#getSmsDefinitions) | **GET** /messaging/v1/sms/definitions | getSmsDefinitions
[**getSmsSendStatusForRecipient**](TransactionalMessagingApi.md#getSmsSendStatusForRecipient) | **GET** /messaging/v1/sms/messages/{messageKey} | getSmsSendStatusForRecipient
[**partiallyUpdateEmailDefinition**](TransactionalMessagingApi.md#partiallyUpdateEmailDefinition) | **PATCH** /messaging/v1/email/definitions/{definitionKey} | partiallyUpdateEmailDefinition
[**partiallyUpdateSmsDefinition**](TransactionalMessagingApi.md#partiallyUpdateSmsDefinition) | **PATCH** /messaging/v1/sms/definitions/{definitionKey} | partiallyUpdateSmsDefinition
[**sendEmailToMultipleRecipients**](TransactionalMessagingApi.md#sendEmailToMultipleRecipients) | **POST** /messaging/v1/email/messages/ | sendEmailToMultipleRecipients
[**sendEmailToSingleRecipient**](TransactionalMessagingApi.md#sendEmailToSingleRecipient) | **POST** /messaging/v1/email/messages/{messageKey} | sendEmailToSingleRecipient
[**sendSmsToMultipleRecipients**](TransactionalMessagingApi.md#sendSmsToMultipleRecipients) | **POST** /messaging/v1/sms/messages/ | sendSmsToMultipleRecipients
[**sendSmsToSingleRecipient**](TransactionalMessagingApi.md#sendSmsToSingleRecipient) | **POST** /messaging/v1/sms/messages/{messageKey} | sendSmsToSingleRecipient


<a name="createEmailDefinition"></a>
# **createEmailDefinition**
> EmailDefinition createEmailDefinition(body)

createEmailDefinition

Creates the definition for an email.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
EmailDefinition body = new EmailDefinition(); // EmailDefinition | JSON Parameters
try {
    EmailDefinition result = apiInstance.createEmailDefinition(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#createEmailDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EmailDefinition**](EmailDefinition.md)| JSON Parameters |

### Return type

[**EmailDefinition**](EmailDefinition.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createSmsDefinition"></a>
# **createSmsDefinition**
> SmsDefinition createSmsDefinition(body)

createSmsDefinition

Creates the definition for an SMS.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
SmsDefinition body = new SmsDefinition(); // SmsDefinition | JSON Parameters
try {
    SmsDefinition result = apiInstance.createSmsDefinition(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#createSmsDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SmsDefinition**](SmsDefinition.md)| JSON Parameters |

### Return type

[**SmsDefinition**](SmsDefinition.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteEmailDefinition"></a>
# **deleteEmailDefinition**
> DeleteSendDefinitionResponse deleteEmailDefinition(definitionKey)

deleteEmailDefinition

Deletes an email definition. You can&#39;t restore a deleted definition. The deleted definition is archived, and a delete location of the definition key is provided in the response for reference. You can reuse a deleted definition key because the information associated with it is copied to a new unique identifier.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the definition to delete
try {
    DeleteSendDefinitionResponse result = apiInstance.deleteEmailDefinition(definitionKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#deleteEmailDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the definition to delete |

### Return type

[**DeleteSendDefinitionResponse**](DeleteSendDefinitionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteQueuedMessagesForEmailDefinition"></a>
# **deleteQueuedMessagesForEmailDefinition**
> DeleteQueuedMessagesForSendDefinitionResponse deleteQueuedMessagesForEmailDefinition(definitionKey)

deleteQueuedMessagesForEmailDefinition

Deletes the queue for an email definition. The email definition must be in inactive status.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the email definition
try {
    DeleteQueuedMessagesForSendDefinitionResponse result = apiInstance.deleteQueuedMessagesForEmailDefinition(definitionKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#deleteQueuedMessagesForEmailDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the email definition |

### Return type

[**DeleteQueuedMessagesForSendDefinitionResponse**](DeleteQueuedMessagesForSendDefinitionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteQueuedMessagesForSmsDefinition"></a>
# **deleteQueuedMessagesForSmsDefinition**
> DeleteQueuedMessagesForSendDefinitionResponse deleteQueuedMessagesForSmsDefinition(definitionKey)

deleteQueuedMessagesForSmsDefinition

Deletes the queue for a SMS definition. The SMS definition must be in inactive status.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the SMS definition
try {
    DeleteQueuedMessagesForSendDefinitionResponse result = apiInstance.deleteQueuedMessagesForSmsDefinition(definitionKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#deleteQueuedMessagesForSmsDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the SMS definition |

### Return type

[**DeleteQueuedMessagesForSendDefinitionResponse**](DeleteQueuedMessagesForSendDefinitionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteSmsDefinition"></a>
# **deleteSmsDefinition**
> DeleteSendDefinitionResponse deleteSmsDefinition(definitionKey)

deleteSmsDefinition

Deletes an sms definition. You can&#39;t restore a deleted definition. The deleted definition is archived, and a delete location of the definition key is provided in the response for reference. You can reuse a deleted definition key because the information associated with it is copied to a new unique identifier.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the definition to delete
try {
    DeleteSendDefinitionResponse result = apiInstance.deleteSmsDefinition(definitionKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#deleteSmsDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the definition to delete |

### Return type

[**DeleteSendDefinitionResponse**](DeleteSendDefinitionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getEmailDefinition"></a>
# **getEmailDefinition**
> EmailDefinition getEmailDefinition(definitionKey)

getEmailDefinition

Gets email definition configuration details for a definition key.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the definition to get
try {
    EmailDefinition result = apiInstance.getEmailDefinition(definitionKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getEmailDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the definition to get |

### Return type

[**EmailDefinition**](EmailDefinition.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getEmailDefinitions"></a>
# **getEmailDefinitions**
> GetEmailDefinitionsResponse getEmailDefinitions(filter, pageSize, page, orderBy)

getEmailDefinitions

Gets a list of email definitions.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String filter = "filter_example"; // String | Filter by status type. Accepted values are active, inactive, or deleted. Valid operations are eq and neq.
BigDecimal pageSize = new BigDecimal(); // BigDecimal | Number of definitions, which are array elements, to return per paged response.
BigDecimal page = new BigDecimal(); // BigDecimal | Page number to return.
String orderBy = "orderBy_example"; // String | Sort by a dimension. You can sort by only one dimension. Accepted values are definitionKey, name, createdDate, modifiedDate, and status.
try {
    GetEmailDefinitionsResponse result = apiInstance.getEmailDefinitions(filter, pageSize, page, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getEmailDefinitions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filter** | **String**| Filter by status type. Accepted values are active, inactive, or deleted. Valid operations are eq and neq. | [optional] [enum: active, inactive, deleted]
 **pageSize** | **BigDecimal**| Number of definitions, which are array elements, to return per paged response. | [optional]
 **page** | **BigDecimal**| Page number to return. | [optional]
 **orderBy** | **String**| Sort by a dimension. You can sort by only one dimension. Accepted values are definitionKey, name, createdDate, modifiedDate, and status. | [optional] [enum: definitionKey, name, createdDate, modifiedDate, status]

### Return type

[**GetEmailDefinitionsResponse**](GetEmailDefinitionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getEmailSendStatusForRecipient"></a>
# **getEmailSendStatusForRecipient**
> GetDefinitionSendStatusForRecipientResponse getEmailSendStatusForRecipient(messageKey)

getEmailSendStatusForRecipient

Gets the send status for a message. Because this route is rate-limited, use it for infrequent verification of a messageKey. To collect send status at scale, subscribe to transactional send events using the Event Notification Service.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String messageKey = "messageKey_example"; // String | Unique identifier to track message send status. You must provide it in singleton requests using the recipient attribute. To provide it in batch requests, use the recipients array attribute. If you don’t provide the message key for recipients, it’s generated in the response.
try {
    GetDefinitionSendStatusForRecipientResponse result = apiInstance.getEmailSendStatusForRecipient(messageKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getEmailSendStatusForRecipient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageKey** | **String**| Unique identifier to track message send status. You must provide it in singleton requests using the recipient attribute. To provide it in batch requests, use the recipients array attribute. If you don’t provide the message key for recipients, it’s generated in the response. |

### Return type

[**GetDefinitionSendStatusForRecipientResponse**](GetDefinitionSendStatusForRecipientResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getEmailsNotSentToRecipients"></a>
# **getEmailsNotSentToRecipients**
> GetDefinitionsNotSentToRecipientsResponse getEmailsNotSentToRecipients(type, pageSize, lastEventId)

getEmailsNotSentToRecipients

Gets a paginated list of messages that were not sent, ordered from oldest to newest.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String type = "type_example"; // String | Only notSent is supported.
Integer pageSize = 56; // Integer | Number of messageKeys (array elements) to return per response page.
Integer lastEventId = 56; // Integer | Event ID from which you want the response to start. To obtain the initial event ID, submit a request without a lastEventId. The events in the response are listed top to bottom from oldest to newest.
try {
    GetDefinitionsNotSentToRecipientsResponse result = apiInstance.getEmailsNotSentToRecipients(type, pageSize, lastEventId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getEmailsNotSentToRecipients");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| Only notSent is supported. |
 **pageSize** | **Integer**| Number of messageKeys (array elements) to return per response page. | [optional]
 **lastEventId** | **Integer**| Event ID from which you want the response to start. To obtain the initial event ID, submit a request without a lastEventId. The events in the response are listed top to bottom from oldest to newest. | [optional]

### Return type

[**GetDefinitionsNotSentToRecipientsResponse**](GetDefinitionsNotSentToRecipientsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getQueueMetricsForEmailDefinition"></a>
# **getQueueMetricsForEmailDefinition**
> GetQueueMetricsForSendDefinitionResponse getQueueMetricsForEmailDefinition(definitionKey)

getQueueMetricsForEmailDefinition

Gets metrics for the messages of an email definition. Applies to messages that are accepted but not yet processed.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the email definition
try {
    GetQueueMetricsForSendDefinitionResponse result = apiInstance.getQueueMetricsForEmailDefinition(definitionKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getQueueMetricsForEmailDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the email definition |

### Return type

[**GetQueueMetricsForSendDefinitionResponse**](GetQueueMetricsForSendDefinitionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getQueueMetricsForSmsDefinition"></a>
# **getQueueMetricsForSmsDefinition**
> GetQueueMetricsForSendDefinitionResponse getQueueMetricsForSmsDefinition(definitionKey)

getQueueMetricsForSmsDefinition

Gets metrics for the messages of a SMS definition. Applies to messages that are accepted but not yet processed.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the SMS definition
try {
    GetQueueMetricsForSendDefinitionResponse result = apiInstance.getQueueMetricsForSmsDefinition(definitionKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getQueueMetricsForSmsDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the SMS definition |

### Return type

[**GetQueueMetricsForSendDefinitionResponse**](GetQueueMetricsForSendDefinitionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getSMSsNotSentToRecipients"></a>
# **getSMSsNotSentToRecipients**
> GetDefinitionsNotSentToRecipientsResponse getSMSsNotSentToRecipients(type, pageSize, lastEventId)

getSMSsNotSentToRecipients

Gets a paginated list of messages that were not sent, ordered from oldest to newest.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String type = "type_example"; // String | Only notSent is supported.
Integer pageSize = 56; // Integer | Number of messageKeys (array elements) to return per response page.
Integer lastEventId = 56; // Integer | Event ID from which you want the response to start. To obtain the initial event ID, submit a request without a lastEventId. The events in the response are listed top to bottom from oldest to newest.
try {
    GetDefinitionsNotSentToRecipientsResponse result = apiInstance.getSMSsNotSentToRecipients(type, pageSize, lastEventId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getSMSsNotSentToRecipients");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| Only notSent is supported. |
 **pageSize** | **Integer**| Number of messageKeys (array elements) to return per response page. | [optional]
 **lastEventId** | **Integer**| Event ID from which you want the response to start. To obtain the initial event ID, submit a request without a lastEventId. The events in the response are listed top to bottom from oldest to newest. | [optional]

### Return type

[**GetDefinitionsNotSentToRecipientsResponse**](GetDefinitionsNotSentToRecipientsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getSmsDefinition"></a>
# **getSmsDefinition**
> SmsDefinition getSmsDefinition(definitionKey)

getSmsDefinition

Gets SMS definition configuration details for a definition key.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the definition to get
try {
    SmsDefinition result = apiInstance.getSmsDefinition(definitionKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getSmsDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the definition to get |

### Return type

[**SmsDefinition**](SmsDefinition.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getSmsDefinitions"></a>
# **getSmsDefinitions**
> GetSmsDefinitionsResponse getSmsDefinitions(filter, pageSize, page, orderBy)

getSmsDefinitions

Gets a list of SMS definitions.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String filter = "filter_example"; // String | Filter by status type. Accepted values are active, inactive, or deleted. Valid operations are eq and neq.
BigDecimal pageSize = new BigDecimal(); // BigDecimal | Number of definitions, which are array elements, to return per paged response.
BigDecimal page = new BigDecimal(); // BigDecimal | Page number to return.
String orderBy = "orderBy_example"; // String | Sort by a dimension. You can sort by only one dimension. Accepted values are definitionKey, name, createdDate, modifiedDate, and status.
try {
    GetSmsDefinitionsResponse result = apiInstance.getSmsDefinitions(filter, pageSize, page, orderBy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getSmsDefinitions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filter** | **String**| Filter by status type. Accepted values are active, inactive, or deleted. Valid operations are eq and neq. | [optional] [enum: active, inactive, deleted]
 **pageSize** | **BigDecimal**| Number of definitions, which are array elements, to return per paged response. | [optional]
 **page** | **BigDecimal**| Page number to return. | [optional]
 **orderBy** | **String**| Sort by a dimension. You can sort by only one dimension. Accepted values are definitionKey, name, createdDate, modifiedDate, and status. | [optional] [enum: definitionKey, name, createdDate, modifiedDate, status]

### Return type

[**GetSmsDefinitionsResponse**](GetSmsDefinitionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getSmsSendStatusForRecipient"></a>
# **getSmsSendStatusForRecipient**
> GetDefinitionSendStatusForRecipientResponse getSmsSendStatusForRecipient(messageKey)

getSmsSendStatusForRecipient

Gets the send status for a message. Because this route is rate-limited, use it for infrequent verification of a messageKey. To collect send status at scale, subscribe to transactional send events using the Event Notification Service.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String messageKey = "messageKey_example"; // String | Unique identifier to track message send status. You must provide it in singleton requests using the recipient attribute. To provide message key in batch requests, use the recipients array attribute. If you don’t provide the message key for recipients, it’s generated in the response.
try {
    GetDefinitionSendStatusForRecipientResponse result = apiInstance.getSmsSendStatusForRecipient(messageKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#getSmsSendStatusForRecipient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageKey** | **String**| Unique identifier to track message send status. You must provide it in singleton requests using the recipient attribute. To provide message key in batch requests, use the recipients array attribute. If you don’t provide the message key for recipients, it’s generated in the response. |

### Return type

[**GetDefinitionSendStatusForRecipientResponse**](GetDefinitionSendStatusForRecipientResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="partiallyUpdateEmailDefinition"></a>
# **partiallyUpdateEmailDefinition**
> EmailDefinition partiallyUpdateEmailDefinition(definitionKey, body)

partiallyUpdateEmailDefinition

Updates a specific email definition.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the definition.
UpdateEmailDefinitionRequest body = new UpdateEmailDefinitionRequest(); // UpdateEmailDefinitionRequest | JSON Parameters
try {
    EmailDefinition result = apiInstance.partiallyUpdateEmailDefinition(definitionKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#partiallyUpdateEmailDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the definition. |
 **body** | [**UpdateEmailDefinitionRequest**](UpdateEmailDefinitionRequest.md)| JSON Parameters |

### Return type

[**EmailDefinition**](EmailDefinition.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="partiallyUpdateSmsDefinition"></a>
# **partiallyUpdateSmsDefinition**
> SmsDefinition partiallyUpdateSmsDefinition(definitionKey, body)

partiallyUpdateSmsDefinition

Updates a specific SMS definition.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String definitionKey = "definitionKey_example"; // String | Unique identifier of the definition.
UpdateSmsDefinitionRequest body = new UpdateSmsDefinitionRequest(); // UpdateSmsDefinitionRequest | JSON Parameters
try {
    SmsDefinition result = apiInstance.partiallyUpdateSmsDefinition(definitionKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#partiallyUpdateSmsDefinition");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **definitionKey** | **String**| Unique identifier of the definition. |
 **body** | [**UpdateSmsDefinitionRequest**](UpdateSmsDefinitionRequest.md)| JSON Parameters |

### Return type

[**SmsDefinition**](SmsDefinition.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="sendEmailToMultipleRecipients"></a>
# **sendEmailToMultipleRecipients**
> SendDefinitionToMultipleRecipientsResponse sendEmailToMultipleRecipients(body)

sendEmailToMultipleRecipients

Sends a message to multiple recipients using an email definition. You can provide a messageKey in the request; otherwise, the messageKey is automatically generated in the response.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
SendEmailToMultipleRecipientsRequest body = new SendEmailToMultipleRecipientsRequest(); // SendEmailToMultipleRecipientsRequest | JSON Parameters
try {
    SendDefinitionToMultipleRecipientsResponse result = apiInstance.sendEmailToMultipleRecipients(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#sendEmailToMultipleRecipients");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendEmailToMultipleRecipientsRequest**](SendEmailToMultipleRecipientsRequest.md)| JSON Parameters |

### Return type

[**SendDefinitionToMultipleRecipientsResponse**](SendDefinitionToMultipleRecipientsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="sendEmailToSingleRecipient"></a>
# **sendEmailToSingleRecipient**
> SendDefinitionToSingleRecipientResponse sendEmailToSingleRecipient(messageKey, body)

sendEmailToSingleRecipient

Sends a message to a single recipient via an email definition using a messageKey path parameter.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String messageKey = "messageKey_example"; // String | Unique identifier used to track message status. Can be automatically created when you create a message or provided as part of the request. Each recipient in a request must have a unique messageKey. If you use a duplicate messageKey in the same send request, the message is rejected.
SendEmailToSingleRecipientRequest body = new SendEmailToSingleRecipientRequest(); // SendEmailToSingleRecipientRequest | JSON Parameters
try {
    SendDefinitionToSingleRecipientResponse result = apiInstance.sendEmailToSingleRecipient(messageKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#sendEmailToSingleRecipient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageKey** | **String**| Unique identifier used to track message status. Can be automatically created when you create a message or provided as part of the request. Each recipient in a request must have a unique messageKey. If you use a duplicate messageKey in the same send request, the message is rejected. |
 **body** | [**SendEmailToSingleRecipientRequest**](SendEmailToSingleRecipientRequest.md)| JSON Parameters |

### Return type

[**SendDefinitionToSingleRecipientResponse**](SendDefinitionToSingleRecipientResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="sendSmsToMultipleRecipients"></a>
# **sendSmsToMultipleRecipients**
> SendDefinitionToMultipleRecipientsResponse sendSmsToMultipleRecipients(body)

sendSmsToMultipleRecipients

Sends a message to multiple recipients using an email definition. You can provide a messageKey in the request; otherwise, the messageKey is automatically generated in the response.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
SendSmsToMultipleRecipientsRequest body = new SendSmsToMultipleRecipientsRequest(); // SendSmsToMultipleRecipientsRequest | JSON Parameters
try {
    SendDefinitionToMultipleRecipientsResponse result = apiInstance.sendSmsToMultipleRecipients(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#sendSmsToMultipleRecipients");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendSmsToMultipleRecipientsRequest**](SendSmsToMultipleRecipientsRequest.md)| JSON Parameters |

### Return type

[**SendDefinitionToMultipleRecipientsResponse**](SendDefinitionToMultipleRecipientsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="sendSmsToSingleRecipient"></a>
# **sendSmsToSingleRecipient**
> SendDefinitionToSingleRecipientResponse sendSmsToSingleRecipient(messageKey, body)

sendSmsToSingleRecipient

Sends a message to a single recipient via a SMS definition using a messageKey path parameter.

### Example
```java
// Import classes:
//import com.github.salesforce.marketingcloud.javasdk.ApiException;
//import com.github.salesforce.marketingcloud.javasdk.api.TransactionalMessagingApi;


TransactionalMessagingApi apiInstance = new TransactionalMessagingApi();
String messageKey = "messageKey_example"; // String | Unique identifier of the definition used to track message status. The messageKey can be created automatically when you create a message, or you can provide it as part of the request. Each recipient in a request must have a unique messageKey. If you use a duplicate messageKey in the same send request, the message is rejected.
SendSmsToSingleRecipientRequest body = new SendSmsToSingleRecipientRequest(); // SendSmsToSingleRecipientRequest | JSON Parameters
try {
    SendDefinitionToSingleRecipientResponse result = apiInstance.sendSmsToSingleRecipient(messageKey, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TransactionalMessagingApi#sendSmsToSingleRecipient");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **messageKey** | **String**| Unique identifier of the definition used to track message status. The messageKey can be created automatically when you create a message, or you can provide it as part of the request. Each recipient in a request must have a unique messageKey. If you use a duplicate messageKey in the same send request, the message is rejected. |
 **body** | [**SendSmsToSingleRecipientRequest**](SendSmsToSingleRecipientRequest.md)| JSON Parameters |

### Return type

[**SendDefinitionToSingleRecipientResponse**](SendDefinitionToSingleRecipientResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

