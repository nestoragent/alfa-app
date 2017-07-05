
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultSet")
public class ResultSet {
    
    @Element
    private ResultList resultList;

    public ResultList getResultList() {
        return resultList;
    }

    public void setResultList(ResultList resultList) {
        this.resultList = resultList;
    }   
}
