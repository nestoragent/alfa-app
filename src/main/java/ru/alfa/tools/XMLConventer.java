
package ru.alfa.tools;

import java.io.StringWriter;
import java.io.Writer;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author Dmitry
 */
public class XMLConventer {

    private Writer writer;
    private Serializer serializer;

    public XMLConventer() {
        writer = new StringWriter();
        serializer = new Persister();
    }

    public String serializerXML(Object object) throws Exception {
        serializer.write(object, writer);
        return writer.toString();
    }

}
