
package ru.alfa.objects.pipe;

import org.simpleframework.xml.Element;

/**
 *
 * @author Dmitry
 */
public class AuthMethodListRow {
    
    @Element
    private String methodCode;  
    @Element
    private String methodDsc;  
    @Element
    private String deviceID;  
    @Element
    private String deviceType;   
    @Element
    private String passwordSize;

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public void setMethodDsc(String methodDsc) {
        this.methodDsc = methodDsc;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setPasswordSize(String passwordSize) {
        this.passwordSize = passwordSize;
    }
    
}
