package ru.alfa.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Created by nestor on 05.07.2017.
 */
public class OrderControllerTest {

    @Test
    public void positiveTestPostOrderValidation() throws Exception {
        //arrange
        OrderController orderController = new OrderController();

        //act
        ResponseEntity response = orderController.postOrder("{\n"
                + "  \"Pins\": \"string\",\n"
                + "  \"AssetId\": 0,\n"
                + "  \"GeneralAgreementId\": 0,\n"
                + "  \"Operation\": 0,\n"
                + "  \"Quantity\": 0,\n"
                + "  \"AttachmentName\": \"string\",\n"
                + "  \"AttachmentBody\": \"string\",\n"
                + "  \"Amount\": 0\n"
                + "}");

        //assert        
        JsonElement jElement = new JsonParser().parse(response.getBody().toString());
        JsonObject jsonObject = jElement.getAsJsonObject();
        Assert.assertEquals("201", Integer.parseInt(jsonObject.get("code").toString()));
    }
}
