package ru.alfa.objects.pipe;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import ru.alfa.objects.OutCommonParms;

/**
 *
 * @author Dmitry
 */
public class WSCustomerOperationAuthorizationMethodsGetResponse {

    @Path("response")
    @Element
    private OutCommonParms outCommonParms;

    @Path("response")
    @Element (name = "outParms")
    private AuthOutParms authOutParms;

    public OutCommonParms getOutCommonParms() {
        return outCommonParms;
    }

    public AuthOutParms getAuthOutParms() {
        return authOutParms;
    }
    
}
