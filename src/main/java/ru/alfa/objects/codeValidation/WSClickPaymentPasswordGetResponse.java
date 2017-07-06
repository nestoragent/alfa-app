
package ru.alfa.objects.codeValidation;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import ru.alfa.objects.OutCommonParms;
import ru.alfa.objects.OutParms;

/**
 *
 * @author Dmitry
 */
public class WSClickPaymentPasswordGetResponse {
    
    @Path("response")
    @Element
    private OutCommonParms outCommonParms;
    
    @Path("response")
    @Element
    private OutParms outParms;

    public OutCommonParms getOutCommonParms() {
        return outCommonParms;
    }
    
    public OutParms getOutParms() {
        return outParms;
    }    
}
