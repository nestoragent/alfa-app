/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 *
 * @author Dmitry
 */
@Root(strict = false)
public class WSCustomerExtendedInfoCLGetResponse {
    
    @Path("response/outParms/resultSet/list[1]")
    @Element
    private String anm;
    @Path("response/outParms/resultSet/list[1]")
    @Element
    private String adt;

    public String getAnm() {
        return anm;
    }

    public String getAdt() {
        return adt;
    }   
}
