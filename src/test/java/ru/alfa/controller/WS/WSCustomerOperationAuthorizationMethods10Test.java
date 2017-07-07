package ru.alfa.controller.WS;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;

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
        ResponseEntity response = wsCustomerOperationAuthorizationMethods10.createPipeOperation("B81206", "NF", "PC3", "PHCL", "value");

        //assert
        JsonElement jelement = new JsonParser().parse(response.getBody().toString());
        JsonObject jobject = jelement.getAsJsonObject();
        Assert.assertNotEquals("", response.getStatusCode());
        Assert.assertNotNull(response.getStatusCode());
        Assert.assertNotEquals("", jobject.get("ref").getAsString());
        Assert.assertNotNull(jobject.get("ref").getAsString());
    }
}