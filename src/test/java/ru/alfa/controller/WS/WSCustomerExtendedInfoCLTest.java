package ru.alfa.controller.WS;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;
import ru.alfa.controller.AssetsController;

import static org.junit.Assert.*;

/**
 * Created by nestor on 06.07.2017.
 */
public class WSCustomerExtendedInfoCLTest {

    @Test
    public void positiveTestGetTelephoneNumber() throws Exception {
        //arrange
        WSCustomerExtendedInfoCL wsCustomerExtendedInfoCL = new WSCustomerExtendedInfoCL();

        //act
        String response = wsCustomerExtendedInfoCL.getTelephoneNumber("B81206");

        //assert
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONObject jsonObject = (JSONObject) obj;
        Assert.assertNotEquals("", jsonObject.get("adt"));
        Assert.assertNotNull(jsonObject.get("adt"));
    }
}