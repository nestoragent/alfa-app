package ru.alfa.controller.WS;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nestor on 07.07.2017.
 */
public class WSClickPaymentPasswordCheckTest {

    @Test
    public void positiveTestCodeValidation() throws Exception {
        //arrange
        WSClickPaymentPasswordCheck wsClickPaymentPasswordCheck = new WSClickPaymentPasswordCheck();

        //act
        String response = wsClickPaymentPasswordCheck.codeValidation("sfioefoasiasdfjaf", "1234");

        //assert
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONObject jsonObject = (JSONObject) obj;
        Assert.assertNotEquals("", jsonObject.get("ref"));
        Assert.assertNotNull(jsonObject.get("ref"));
    }
}