
package ru.alfa.objects;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;
import ru.alfa.tools.EmptyElementConverter;

/**
 *
 * @author Dmitry
 */
@Root(strict = false)
public class OutParms {
    
    @Element
    @Convert(EmptyElementConverter.class)
    private  String actionId;  

    public String getActionId() {
        return actionId;
    }
}
