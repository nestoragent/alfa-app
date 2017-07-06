package ru.alfa.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nestor on 05.07.2017.
 */
public class ValidationControllerTest {

    @Test
    public void positiveTestPostOrderValidation() throws Exception {
        //arrange
        ValidationController validationController = new ValidationController();

        //act
        String response = validationController.postOrderValidation("1", "2", "3", "5", "6", "7");

        //assert
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONObject jsonObject = (JSONObject) obj;
        Assert.assertEquals(2, Integer.parseInt(jsonObject.get("status").toString()));
        Assert.assertNotNull(jsonObject.get("tradeAccount"));
        Assert.assertNotEquals("", jsonObject.get("tradeAccount"));
    }
}