package org.utils;

import java.net.URL;

public class PathFXML {

    public static URL getPath(String fxmlFileName) {
        System.out.println(fxmlFileName);
        System.out.println(PathFXML.class.getResource("/org/view/" + fxmlFileName));
        return PathFXML.class.getResource("/org/view/" + fxmlFileName);
    }

}