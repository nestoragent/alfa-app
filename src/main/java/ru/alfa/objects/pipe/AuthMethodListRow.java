package ru.alfa.objects.pipe;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.convert.Convert;
import ru.alfa.tools.EmptyElementConverter;

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
    @Convert(EmptyElementConverter.class)
    private String deviceID;
    @Element
    @Convert(EmptyElementConverter.class)
    private String deviceType;
    @Element
    private String passwordSize;

    public String getMethodCode() {
        return methodCode;
    }

    public String getMethodDsc() {
        return methodDsc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getPasswordSize() {
        return passwordSize;
    }

}
