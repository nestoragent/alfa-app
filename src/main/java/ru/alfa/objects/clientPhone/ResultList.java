
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;


public class ResultList {

    @Attribute (name = "type", required = false)  
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    } 

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
