/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alfa.objects.clientPhone;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 *
 * @author Dmitry
 */
@Root(strict = false)
public class WSCustomerExtendedInfoCLGetResponse {
    
    @Path("response/outParms")
    @ElementList(name = "resultSet")
    private List<ResultList> resultSet; 

    public List<ResultList> getResultSet() {
        return resultSet;
    }
}
