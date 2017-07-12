package ru.alfa.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;
import ru.alfa.model.OrderValidation;

import static org.junit.Assert.*;
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
        ResponseEntity response = orderController.postOrder("1", "2", "3", "4", "5", "6", "7", "8", "9");

        //assert        
        JsonElement jElement = new JsonParser().parse(response.getBody().toString());
        JsonObject jsonObject = jElement.getAsJsonObject();
        Assert.assertEquals("201", Integer.parseInt(jsonObject.get("code").toString()));        
    }
}
