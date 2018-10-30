package edu.uncg.csc.bigo.weather.models.util;
/**
 * This class offers the ability to dynamically load classes in packages.
 *
 * @updated 2018/10/30
 * @authors Hao Zhang
 */


import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;


public final class DynamicPackageLoader {
    /**
     * This method dynamically loads all the classes in a given package as subclasses of a given
     *     superclass.
     * The code has been adapted from: https://dzone.com/articles/get-all-classes-within-package
     *
     * @param _superClass The superclass to cast the dynamically-loaded classes to
     * @param _packageName The name of the package to dynamically load classes from
     * @return An array of dynamically-loaded classes that are subclasses of the given superclass
     * @throws ClassNotFoundException An exception indicating failure to dynamically load a class
     * @throws IOException An exception indicating that the given package name is invalid
     * @throws URISyntaxException An exception indicating that there was a failure converting a URI
     */
    public static Class[] loadPackageAs(Class _superClass, String _packageName)
            throws ClassNotFoundException, IOException, URISyntaxException
    {
        ArrayList<Class> classes = new ArrayList();
        ClassLoader classLoader = DynamicPackageLoader.class.getClassLoader();
        Enumeration<URL> resources = classLoader.getResources(_packageName.replace(".", "/"));

        // Make sure the package exists.
        if (resources.hasMoreElements()) {
            // Iterate through each file in the package.
            for (File file : new File(resources.nextElement().toURI().getPath()).listFiles()) {
                // Get the name of the current file.
                String resourceName = file.getName();

                // Only process class files.
                if (resourceName.endsWith(".class")) {
                    // Strip the extension.
                    String className = resourceName.substring(0, resourceName.length() - 6);

                    // Dynamically load the class.
                    Class clazz = classLoader.loadClass(_packageName + "." + className);

                    // Cast the class to be a subclass of the given superclass and store it.
                    classes.add(clazz.asSubclass(_superClass));
                }
            }

            // Return the dynamically-loaded classes in an array.
            return classes.toArray(new Class[] {});
        } else {
            // The package does not exist.
            throw new InvalidObjectException(
                    String.format("The package \"%s\" does not exist!", _packageName)
            );
        }
    }
}