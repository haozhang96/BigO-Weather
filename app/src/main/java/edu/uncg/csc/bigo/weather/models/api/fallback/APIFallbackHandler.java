package edu.uncg.csc.bigo.weather.models.api.fallback;
/**
 * This class defines a handler class that dynamically loads all implementations for a specific API
 *     type within a given package, and proxies all method calls to the first working API available.
 *
 * @updated 2018/11/01
 * @authors Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.api.API;
import edu.uncg.csc.bigo.weather.models.api.APIResponse;
import edu.uncg.csc.bigo.weather.models.util.ClassSingletonPair;
import edu.uncg.csc.bigo.weather.models.util.DynamicPackageLoader;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public abstract class APIFallbackHandler<T extends API> {
    private ClassSingletonPair<Class<T>, T>[] apis;


    /**
     * This constructs an APIFallbackHandler object that dynamically loads all classes within a
     *     package that all inherit from the provided base API class.
     * @param _baseAPIClass The base API class that all the dynamic classes inherit from
     * @param _fallbackPackageName The name of the package to load all of the
     * @throws ClassNotFoundException An exception indicating failure to dynamically load a class
     * @throws IOException An exception indicating that the given package name is invalid
     *
     */
    protected APIFallbackHandler(
            Class<T> _baseAPIClass, String _fallbackPackageName, Class<APIFallbackNames> _fallbackNames
    )
            throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException
    {
        Log.d("Test", ((String[]) _fallbackNames.getField("names").get(null)).toString());
        // Dynamically load all the classes in the given package
        Class<T>[] apiClasses = DynamicPackageLoader.loadPackageClassesAs(
                _baseAPIClass,
                _fallbackPackageName,
                (String[]) _fallbackNames.getField("names").get(null)
        );

        // Store an array of classes and their singletons
        int index = 0;
        this.apis = new ClassSingletonPair[apiClasses.length];
        for (Class<T> clazz : apiClasses) {
            try {
                this.apis[index++] = new ClassSingletonPair(clazz, clazz.newInstance());
            } catch (Exception exception) {
                System.err.println(String.format(
                        "An error has occurred while instantiating %s for %s: %s",
                        clazz.getSimpleName(),
                        this.getClass().getSimpleName(),
                        exception.getMessage()
                ));
            }
        }
    }


    /**
     * This method calls a class method on the first available API implementation.
     * @param _methodName The name of the method to call
     * @param _argumentTypes The argument types of the method call
     * @param _arguments The arguments to call the method with
     * @return An encapsulated method call response
     * @throws NoWorkingAPIAvailableException An exception indicating that none of the available
     *     APIs were able to successfully call the method
     * @throws NoSuchMethodException An exception indicating that the method doesn't exist
     */
    protected final APIResponse<Object> apiCallClassMethod(
            String _methodName,
            Class[] _argumentTypes,
            Object[] _arguments
    )
            throws NoWorkingAPIAvailableException, NoSuchMethodException
    {
        // Go through each of the available APIs and try to call its method until successful.
        for (ClassSingletonPair<Class<T>, T> api : this.apis) {
            try {
                return this.callClassMethod(api, _methodName, _argumentTypes, _arguments);
            } catch (IllegalAccessException | InvocationTargetException exception) {
                System.err.println(String.format(
                        "An exception has occurred while calling the API %s.%s: %s",
                        api.getClazz().getSimpleName(), _methodName, exception.getMessage()
                ));
            }
        }

        // There were no APIs available that could handle the method call.
        throw new NoWorkingAPIAvailableException(String.format(
                "There is currently no working API available to handle the %s call!",
                _methodName
        ));
    }


    /**
     * This method calls an instance method on the first available API implementation.
     * @param _methodName The name of the method to call
     * @param _argumentTypes The argument types of the method call
     * @param _arguments The arguments to call the method with
     * @return An encapsulated method call response
     * @throws NoWorkingAPIAvailableException An exception indicating that none of the available
     *     APIs were able to successfully call the method
     * @throws NoSuchMethodException An exception indicating that the method doesn't exist
     */
    protected final APIResponse<Object> apiCallInstanceMethod(
            String _methodName,
            Class[] _argumentTypes,
            Object[] _arguments
    )
            throws NoWorkingAPIAvailableException, NoSuchMethodException
    {
        Log.d("Hao", "In APIFallbackHandler.apiCallInstanceMethod");
        // Go through each of the available APIs and try to call its method until successful.
        for (ClassSingletonPair<Class<T>, T> api : this.apis) {
            try {
                return this.callInstanceMethod(api, _methodName, _argumentTypes, _arguments);
            } catch (IllegalAccessException | InvocationTargetException exception) {
                System.err.println(String.format(
                        "An exception has occurred while calling the API %s.%s: %s",
                        api.getClazz().getSimpleName(), _methodName, exception.getMessage()
                ));
            }
        }

        // There were no APIs available that could handle the method call.
        throw new NoWorkingAPIAvailableException(String.format(
                "There is currently no working API available to handle the %s call!",
                _methodName
        ));
    }


    /**
     * This method asserts whether the provided API belongs to the list of dynamically-loaded APIs.
     * @param _api The API to check
     * @throws IllegalArgumentException An exception indicating that the provided API does not
     *     belong to the list of dynamically-loaded APIs
     */
    private final void assertAPIBelongs(Class<T> _api) throws IllegalArgumentException {
        for (ClassSingletonPair api : this.apis) {
            if (api.getClazz().equals(_api)) {
                return;
            }
        }

        throw new IllegalArgumentException(String.format(
                "The API (arg1: %s) provided does not belong in the usable APIs of %s!",
                _api.getSimpleName(), this.getClass().getSimpleName()
        ));
    }


    /**
     * This method calls a static class method on a specified API implementation.
     * @param _api The API implementation to call the method on
     * @param _methodName The name of the method to call
     * @param _argumentTypes The argument types of the method call
     * @param _arguments The arguments to call the method with
     * @return An encapsulated method call response
     * @throws NoSuchMethodException An exception indicating that the method doesn't exist
     * @throws IllegalAccessException An exception indicating that the method was called incorrectly
     * @throws InvocationTargetException An exception indicating a problem with the method call
     */
    private final APIResponse<Object> callClassMethod(
            ClassSingletonPair<Class<T>, T> _api,
            String _methodName,
            Class[] _argumentTypes,
            Object[] _arguments
    )
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        // Make sure the provided API belongs to the list of dynamically-loaded APIs.
        this.assertAPIBelongs(_api.getClazz());

        // Retrieve the static API method.
        Method apiMethod = _api.getClazz().getDeclaredMethod(_methodName, _argumentTypes);

        // Call the static API method.
        Object apiMethodResponse = apiMethod.invoke(null, _arguments);

        // Return an encapsulated API response object with the API used attached to it.
        return new APIResponse(_api.getClazz(), apiMethodResponse);
    }


    /**
     * This method calls an instance method on a specified API implementation.
     * @param _api The API implementation to call the method on
     * @param _methodName The name of the method to call
     * @param _argumentTypes The argument types of the method call
     * @param _arguments The arguments to call the method with
     * @return An encapsulated method call response
     * @throws NoSuchMethodException An exception indicating that the method doesn't exist
     * @throws IllegalAccessException An exception indicating that the method was called incorrectly
     * @throws InvocationTargetException An exception indicating a problem with the method call
     */
    private final APIResponse<Object> callInstanceMethod(
            ClassSingletonPair<Class<T>, T> _api,
            String _methodName,
            Class[] _argumentTypes,
            Object[] _arguments
    )
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        // Make sure the provided API belongs to the list of dynamically-loaded APIs.
        this.assertAPIBelongs(_api.getClazz());

        // Retrieve the instance API method.
        Method apiMethod = _api.getClazz().getDeclaredMethod(_methodName, _argumentTypes);

        // Call the instance API method.
        Object apiMethodResponse = apiMethod.invoke(_api.getSingleton(), _arguments);

        // Return an encapsulated API response object with the API used attached to it.
        return new APIResponse(_api.getClazz(), apiMethodResponse);
    }
}