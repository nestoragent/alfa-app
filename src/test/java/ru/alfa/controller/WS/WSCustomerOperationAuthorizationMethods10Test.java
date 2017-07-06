package ru.alfa.controller.WS;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nestor on 06.07.2017.
 */
public class WSCustomerOperationAuthorizationMethods10Test {

    @Test
    public void positiveTestCreatePipeOperation() throws Exception {
        //arrange
        WSCustomerOperationAuthorizationMethods10 wsCustomerOperationAuthorizationMethods10 =
                new WSCustomerOperationAuthorizationMethods10();

        //act
        String response = wsCustomerOperationAuthorizationMethods10.createPipeOperation("B81206", "NF", "PC3", "PHCL", "value");

        //assert
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONObject jsonObject = (JSONObject) obj;
        Assert.assertNotEquals("", jsonObject.get("ref"));
        Assert.assertNotNull(jsonObject.get("ref"));
    }
}