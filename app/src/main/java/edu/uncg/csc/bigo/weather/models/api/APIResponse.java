package edu.uncg.csc.bigo.weather.models.api;
/**
 * This class encapsulates an API's response by tying the API used with its response.
 * @param <T> The API response type
 *
 * @updated 2018/10/31
 * @authors Hao Zhang
 */


public class APIResponse<T> {
    private final Class<API> api;
    private final T response;


    /**
     * This constructs an APIResponse object with an API and its response.
     * @param _api The API that returned the response
     * @param _response The response of the API
     */
    public APIResponse(Class<API> _api, T _response) {
        this.api = _api;
        this.response = _response;
    }


    /**
     * This method returns the API that returned the response.
     * @return The API that returned the response
     */
    public Class<API> getAPI() {
        return this.api;
    }


    /**
     * This method returns the response of the API.
     * @return The response of the API
     */
    public T getResponse() {
        return this.getResponse();
    }
}