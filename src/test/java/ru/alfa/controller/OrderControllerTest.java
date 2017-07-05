package ru.alfa.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;
import ru.alfa.model.OrderValidation;

import static org.junit.Assert.*;

/**
 * Created by nestor on 05.07.2017.
 */
public class OrderControllerTest {

    @Test
    public void positiveTestPostOrderValidation() throws Exception {
        //arrange
        OrderController orderController = new OrderController();

        //act
        String response = orderController.postOrderValidation("1", 2, 3, 5, 6, 7, "");

        //assert
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONObject jsonObject = (JSONObject) obj;
        Assert.assertEquals("201", jsonObject.get("code"));
    }
}