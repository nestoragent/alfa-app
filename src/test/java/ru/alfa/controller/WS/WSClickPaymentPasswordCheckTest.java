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
public class WSClickPaymentPasswordCheckTest {

    @Test
    public void positiveTestCodeValidation() throws Exception {
        //arrange
        WSClickPaymentPasswordCheck wsClickPaymentPasswordCheck = new WSClickPaymentPasswordCheck();

        //act
        ResponseEntity response = wsClickPaymentPasswordCheck.codeValidation("sfioefoasiasdfjaf", "1234");

        //assert
        JsonElement jElement = new JsonParser().parse(response.getBody().toString());
        JsonObject jObject = jElement.getAsJsonObject();
        Assert.assertNotEquals("", response.getStatusCode());
        Assert.assertNotNull(response.getStatusCode());
        Assert.assertNotNull(jObject.get("status"));
        Assert.assertEquals("success", jObject.get("status").getAsString());
    }
}