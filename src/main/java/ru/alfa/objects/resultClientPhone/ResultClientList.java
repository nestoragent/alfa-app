/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alfa.objects.resultClientPhone;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "list")
@Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "p548")
public class ResultClientList {

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
