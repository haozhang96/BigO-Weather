package edu.uncg.csc.bigo.weather.models.api;
/**
 * This abstract class describes a REST API.
 * It is only to be used by API classes extending it.
 *
 * @updated 2018/09/25
 * @authors Hao Zhang
 */


public abstract class RESTAPI extends API {
    // This field specifies the endpoint URL of the REST API.
    protected final String endpoint;


    /**
     * This constructs a RESTAPI instance with the endpoint URL string of a REST API.
     * @param _endpoint A REST API endpoint URL string
     */
    protected RESTAPI(String _endpoint) {
        this.endpoint = _endpoint;
    }


    /**
     * This method defines a way of invoking the pre-set API endpoint URL and receiving a response.
     * @param _endpointFormatters Formatters to format the API endpoint URL on invocation
     * @return An object of any arbitrary type that was returned from the API sub-class based on its
     *     implementation
     * @throws Exception An exception of any arbitrary type that was thrown from the API sub-class
     *     based on its implementation
     */
    protected abstract Object getResponse(Object ..._endpointFormatters) throws Exception;
}