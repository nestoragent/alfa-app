
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 *
 * @author Dmitry
 */

public class ResultList {

    @Element
    private String anm;
    @Element
    private String adt;

    public String getAnm() {
        return anm;
    }

    public String getAdt() {
        return adt;
    }
}
