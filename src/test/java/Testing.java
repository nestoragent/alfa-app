
import java.util.logging.Level;
import java.util.logging.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.alfa.getters.SendAndValidCode;
import ru.alfa.objects.clientPhone.PhoneEnvelopeSuccess;

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
            String bodyXML = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
"   <soapenv:Body>\n" +
"      <ns3:WSCustomerExtendedInfoCLGetResponse xmlns:ns3=\"http://WSCustomerExtendedInfoCL12.EQ.CS.ws.alfabank.ru\" xmlns:ns2=\"http://WSCommonTypes10.CS.ws.alfabank.ru\">\n" +
"         <response>\n" +
"            <outCommonParms>\n" +
"               <outCommonParmsExt>\n" +
"                  <name>logUID</name>\n" +
"                  <value>eqWS7-170706-101602-00540</value>\n" +
"               </outCommonParmsExt>\n" +
"            </outCommonParms>\n" +
"            <outParms>\n" +
"               <aig>B7GRP</aig>\n" +
"               <cus>ALNIOX</cus>\n" +
"               <clc></clc>\n" +
"               <cun>Андреев Андрей Андреевич</cun>\n" +
"               <cpnc>ALNIOX</cpnc>\n" +
"               <das>Андрей</das>\n" +
"               <c1r></c1r>\n" +
"               <c2r></c2r>\n" +
"               <c3r></c3r>\n" +
"               <c4r></c4r>\n" +
"               <c5r></c5r>\n" +
"               <p1r></p1r>\n" +
"               <p2r></p2r>\n" +
"               <p3r>O71</p3r>\n" +
"               <p4r></p4r>\n" +
"               <p5r></p5r>\n" +
"               <ctp>AA</ctp>\n" +
"               <cub>N</cub>\n" +
"               <cuc>N</cuc>\n" +
"               <cud>N</cud>\n" +
"               <cuz>N</cuz>\n" +
"               <sac></sac>\n" +
"               <aco>AAA</aco>\n" +
"               <crf>668989778781</crf>\n" +
"               <lnm></lnm>\n" +
"               <ca2></ca2>\n" +
"               <cnap>RU</cnap>\n" +
"               <cnar>RU</cnar>\n" +
"               <cnal>RU</cnal>\n" +
"               <cod>2016-03-25</cod>\n" +
"               <dcc>0001-01-01</dcc>\n" +
"               <dlm>2016-11-25</dlm>\n" +
"               <itrt>0.0000000</itrt>\n" +
"               <brnm>BSFI</brnm>\n" +
"               <crb1>B0</crb1>\n" +
"               <crb2>B0</crb2>\n" +
"               <adj>0.0000000</adj>\n" +
"               <ercp></ercp>\n" +
"               <ercc></ercc>\n" +
"               <drc>Y</drc>\n" +
"               <grps></grps>\n" +
"               <cuna></cuna>\n" +
"               <dasa></dasa>\n" +
"               <cunm></cunm>\n" +
"               <cnai>RU</cnai>\n" +
"               <grp></grp>\n" +
"               <mtb></mtb>\n" +
"               <etx>N</etx>\n" +
"               <yfon>N</yfon>\n" +
"               <dfrq>0</dfrq>\n" +
"               <fon>ALNIOX</fon>\n" +
"               <fol>XXX</fol>\n" +
"               <del></del>\n" +
"               <stmp>1247221404173624</stmp>\n" +
"               <cref>BSFIH00002722</cref>\n" +
"               <oatp>R</oatp>\n" +
"               <occl>I</occl>\n" +
"               <hdd></hdd>\n" +
"               <dded>0001-01-01</dded>\n" +
"               <rddh></rddh>\n" +
"               <ytri>N</ytri>\n" +
"               <yret>N</yret>\n" +
"               <ypla>N</ypla>\n" +
"               <yopi>Y</yopi>\n" +
"               <ynet>N</ynet>\n" +
"               <yri1></yri1>\n" +
"               <yri2></yri2>\n" +
"               <yri3></yri3>\n" +
"               <yri4></yri4>\n" +
"               <pcus></pcus>\n" +
"               <pclc></pclc>\n" +
"               <cs></cs>\n" +
"               <cfrq></cfrq>\n" +
"               <fcyc></fcyc>\n" +
"               <cssa></cssa>\n" +
"               <pstm>0001-01-01</pstm>\n" +
"               <nstm>0001-01-01</nstm>\n" +
"               <stn>0</stn>\n" +
"               <ocid>ALNIOX</ocid>\n" +
"               <clsf>9999-12-31</clsf>\n" +
"               <clst>9999-12-31</clst>\n" +
"               <cltv></cltv>\n" +
"               <cltp></cltp>\n" +
"               <drty></drty>\n" +
"               <mrty></mrty>\n" +
"               <seid></seid>\n" +
"               <cst></cst>\n" +
"               <auno>0</auno>\n" +
"               <resultSet>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoAlphanumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>PHCL</anm>\n" +
"                     <adt>79265302612</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoCode\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>OPCL</anm>\n" +
"                     <adt>XX</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoDate\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>DACL</anm>\n" +
"                     <adt>2017-01-15T21:00:00.000Z</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoNumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>TMCL</anm>\n" +
"                     <adt>153633</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoAlphanumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>IMCL</anm>\n" +
"                     <adt>791849999910000</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoDate\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>DAIM</anm>\n" +
"                     <adt>2016-12-01T21:00:00.000Z</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoNumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>TMIM</anm>\n" +
"                     <adt>140231</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoAlphanumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>UICL</anm>\n" +
"                     <adt>IBSR</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoDate\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>DAEM</anm>\n" +
"                     <adt>0000-12-31T21:00:00.000Z</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoNumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>TMEM</anm>\n" +
"                     <adt>0</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoCode\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>CTRR</anm>\n" +
"                     <adt>07700</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoAlphanumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>DSGN</anm>\n" +
"                     <adt>2</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoAlphanumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>LOTP</anm>\n" +
"                     <adt>N</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoAlphanumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>TIPS</anm>\n" +
"                     <adt>N</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoAlphanumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>LITE</anm>\n" +
"                     <adt>N</adt>\n" +
"                  </list>\n" +
"                  <list xsi:type=\"ns2:WSTypeAddInfoAlphanumeric\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"                     <anm>RCPW</anm>\n" +
"                     <adt>Y</adt>\n" +
"                  </list>\n" +
"               </resultSet>\n" +
"            </outParms>\n" +
"         </response>\n" +
"      </ns3:WSCustomerExtendedInfoCLGetResponse>\n" +
"   </soapenv:Body>\n" +
"</soapenv:Envelope>";
            Serializer serializer = new Persister();
            PhoneEnvelopeSuccess envelope = serializer.read(PhoneEnvelopeSuccess.class, bodyXML);
            new SendAndValidCode("dfsfdsf312",1232).codeValidation();
        } catch (Exception ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
