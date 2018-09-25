package edu.uncg.csc.bigo.weather.models.api;
/**
 * This abstract class describes a REST API.
 * It is only to be used by final API classes extending it.
 *
 * @updated 2018/09/25
 * @authors Hao Zhang
 */


public abstract class RESTAPI {
    protected final String endpoint;

    protected RESTAPI(String _endpoint) {
        this.endpoint = _endpoint;
    }

    protected abstract Object getResponse(Object ..._endpointFormatters) throws Exception;
}