
package ru.alfa.objects;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "resultSet")
public class ResultClientPhone {
    
    @Element
    private ResultClientList clientList;

    public ResultClientList getClientList() {
        return clientList;
    }

    public void setClientList(ResultClientList clientList) {
        this.clientList = clientList;
    }
    
    
    
}
