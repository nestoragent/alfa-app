package ru.alfa.objects.pipe;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.convert.Convert;
import ru.alfa.tools.EmptyElementConverter;

/**
 *
 * @author Dmitry
 */
public class AuthOutParms {

    @Element
    private String ref;
    @Element
    @Convert(EmptyElementConverter.class)
    private String actionId;

    @Path("authMethodList")
    @ElementList(name = "authMethodListRow", inline = true, required = false)
    private List<AuthMethodListRow> list;
    

    public String getRef() {
        return ref;
    }

    public String getActionId() {
        return actionId;
    }

    public List<AuthMethodListRow> getList() {
        return list;
    }
}
