
import java.util.logging.Level;
import java.util.logging.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import ru.alfa.getters.GetterClientPhone;
import ru.alfa.getters.GetterPipeOperation;
import ru.alfa.getters.SendAndValidCode;
import ru.alfa.objects.clientPhone.ResultSet;
import ru.alfa.objects.codeValidation.CodeEnvelopeSuccess;
import ru.alfa.objects.codeValidation.SMSEnvelopeSuccess;
import ru.alfa.objects.pipe.PipeEnvelopeSuccess;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Testing {
    
    public static void main(String[] args) {      
        try {
            String bodyXML = "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
"   <S:Header/>\n" +
"   <S:Body>\n" +
"      <ns3:WSClickPaymentPasswordCheckResponse xmlns:ns2=\"http://WSCommonTypes10.CS.ws.alfabank.ru\" xmlns:ns3=\"http://WSClickPaymentPassword10.PS.CS.ws.alfabank.ru\">\n" +
"         <response>\n" +
"            <outCommonParms>\n" +
"               <outCommonParmsExt>\n" +
"                  <name>logUID</name>\n" +
"                  <value>200000285805279</value>\n" +
"               </outCommonParmsExt>\n" +
"            </outCommonParms>\n" +
"            <outParms>\n" +
"               <actionId/>\n" +
"               <messageList/>"
                    + "</outParms>\n" +
"         </response>\n" +
"      </ns3:WSClickPaymentPasswordCheckResponse>\n" +
"   </S:Body>\n" +
"</S:Envelope>";
            Serializer serializer = new Persister(new AnnotationStrategy());
            CodeEnvelopeSuccess envelopeSuccess = serializer.read(CodeEnvelopeSuccess.class, bodyXML);
            new SendAndValidCode("dfsfdsf312",1232).codeValidation();
        } catch (Exception ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
