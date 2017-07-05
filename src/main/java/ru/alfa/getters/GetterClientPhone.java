package ru.alfa.getters;


import ru.alfa.objects.InCommonParms;
import ru.alfa.objects.clientPhone.ResultSet;
import ru.alfa.objects.clientPhone.PhoneEnvelope;
import ru.alfa.objects.clientPhone.WSCustomerExtendedInfoCLGet;
import ru.alfa.requests.RequestRetrofitXML;
import ru.alfa.tools.XMLConventer;

public class GetterClientPhone {

    private final String clientPIN;

    /*   
    *����������� � �������� ��������
    *String clientPIN - ��� �������
     */
    public GetterClientPhone() {
        this.clientPIN = "B81206";
    }

    /*   
    *����������� ����������� � �������� ������� ���������� ��� �������
    *String clientPIN - ��� �������
     */
    public GetterClientPhone(String clientPIN) {
        this.clientPIN = clientPIN;
    }

    /*
    * ���������� �����
    * @param clientPIN - ��� �������
    * @return String - ����� ��������
    * @throws Exception - ������ ��������/��������� ������ �� �������
     */
    public String getPhone() throws Exception {

        PhoneEnvelope phoneEnvelope = new PhoneEnvelope();
        WSCustomerExtendedInfoCLGet cLGet = new WSCustomerExtendedInfoCLGet(clientPIN);
        cLGet.setInCommonParms(new InCommonParms());
        phoneEnvelope.setcLGet(cLGet);

        String xml = new XMLConventer().serializerXML(phoneEnvelope);

        RequestRetrofitXML requestRetrofit = new RequestRetrofitXML();
        ResultSet resultClientPhone = requestRetrofit.postWSCustomerExtendedInfoCL(xml);
        if (resultClientPhone != null) {
            if (resultClientPhone.getResultList().getAnm().equals("PHCL")) {
                return resultClientPhone.getResultList().getAdt();
            }
        }
        return null;
    }

}
