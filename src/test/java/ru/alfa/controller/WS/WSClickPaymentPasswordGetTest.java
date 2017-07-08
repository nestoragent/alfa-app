package ru.alfa.controller.WS;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Created by nestor on 07.07.2017.
 */
public class WSClickPaymentPasswordGetTest {

    @Test
    public void positiveTestSendSMS() throws Exception {
        //arrange
        WSClickPaymentPasswordGet wsClickPaymentPasswordGet = new WSClickPaymentPasswordGet();

        //act
        ResponseEntity response = wsClickPaymentPasswordGet.sendSMS("B81206", "SMSPWD");

        //assert
        JsonElement jElement = new JsonParser().parse(response.getBody().toString());
        JsonObject jObject = jElement.getAsJsonObject();
        Assert.assertNotEquals("", response.getStatusCode());
        Assert.assertNotNull(response.getStatusCode());
        Assert.assertNotEquals("", jObject.get("ref"));
        Assert.assertNotNull(jObject.get("ref"));
    }
}