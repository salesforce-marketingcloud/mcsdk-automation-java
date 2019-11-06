
# GetDefinitionsNotSentToRecipientsResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**lastEventID** | **Integer** | Event ID from which you want the response to start. To obtain the initial event ID, submit a request without a lastEventId. The events in the response are listed top to bottom from oldest to newest |  [optional]
**messages** | [**List&lt;GetDefinitionsNotSentToRecipientsMessage&gt;**](GetDefinitionsNotSentToRecipientsMessage.md) |  |  [optional]
**count** | **Integer** | Number of pages |  [optional]
**requestId** | **String** | The ID of the request |  [optional]
**pageSize** | **Integer** | Number of definitions, which are array elements, to return per paged response. |  [optional]



