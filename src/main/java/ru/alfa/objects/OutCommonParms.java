
package ru.alfa.objects;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 *
 * @author Dmitry
 */
public class OutCommonParms {
    
    @Path("outCommonParmsExt")
    @Element
    private String name;
    @Path("outCommonParmsExt")
    @Element
    private String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
    
}
