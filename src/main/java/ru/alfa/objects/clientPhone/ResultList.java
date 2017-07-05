
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "list")
@Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "p548")
public class ResultList {

    @Attribute (name = "xsi:type")   
    private String type = "p548:WSTypeAddInfoAlphanumeric";

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

    public void setAnm(String anm) {
        this.anm = anm;
    }

    public String getAdt() {
        return adt;
    }

    public void setAdt(String adt) {
        this.adt = adt;
    }
}
