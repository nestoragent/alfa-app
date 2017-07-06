package ru.alfa.objects.pipe;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

/**
 *
 * @author Dmitry
 */
public class AuthOutParms {

    @Element
    private String ref;
    @Element
    private String actionId;

    @Path("authMethodList")
    @ElementList(name = "authMethodListRow")
    private List<AuthMethodListRow> list;
    

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public List<AuthMethodListRow> getList() {
        return list;
    }

    public void setList(List<AuthMethodListRow> list) {
        this.list = list;
    }
}
