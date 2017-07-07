package ru.alfa.controller.WS;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;
import ru.alfa.controller.AssetsController;

import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;

/**
 * Created by nestor on 06.07.2017.
 */
public class WSCustomerExtendedInfoCLTest {

    @Test
    public void positiveTestGetTelephoneNumber() throws Exception {
        //arrange
        WSCustomerExtendedInfoCL wsCustomerExtendedInfoCL = new WSCustomerExtendedInfoCL();

        //act
        ResponseEntity response = wsCustomerExtendedInfoCL.getTelephoneNumber("B81206");

        //assert
        JsonElement jelement = new JsonParser().parse(response.getBody().toString());
        JsonObject jobject = jelement.getAsJsonObject();
        Assert.assertNotEquals("", response.getStatusCode());
        Assert.assertNotNull(response.getStatusCode());
        Assert.assertNotEquals("", jobject.get("adt").getAsString());
        Assert.assertNotNull(jobject.get("adt").getAsString());
    }
}
