package edu.uncg.csc.bigo.weather.models.api;


import edu.uncg.csc.bigo.weather.models.util.DynamicPackageLoader;


public abstract class APIFallbackHandler {
    private final Class[] apis;


    protected APIFallbackHandler(Class _baseAPIClass, String _fallbackPackageName)
            throws Exception
    {
        this.apis = DynamicPackageLoader.loadPackageAs(_baseAPIClass, _fallbackPackageName);
    }


    protected final Object apiCallStaticMethod(String _methodName, Class ..._argumentTypes)
            throws NoValidAPIAvailableException, Exception
    {
        for (Class api : this.apis) {

            try {
                api.getDeclaredMethod(_methodName, null).invoke(null, null);
            } catch (NoSuchMethodException e) {

            }
        }

        throw new NoValidAPIAvailableException("");
    }
}