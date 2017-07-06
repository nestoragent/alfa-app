
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "resultSet")
@Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi")
public class ResultSet {
    
    @Element(name = "list")
    @Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "p548")
    private ResultList resultList;

    public ResultList getResultList() {
        return resultList;
    }  
}
