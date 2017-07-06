
package ru.alfa.objects;

import org.simpleframework.xml.Element;

/**
 *
 * @author Dmitry
 */
public class OutParms {
    
    @Element
    private  String actionId;  

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }
}
