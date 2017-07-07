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
public class ValidationControllerTest {

    @Test
    public void positiveTestPostOrderValidation() throws Exception {
        //arrange
        ValidationController validationController = new ValidationController();

        //act
        ResponseEntity response = validationController.postOrderValidation("1", "2", "3", "5", "6", "7");

        //assert
        JsonElement jElement = new JsonParser().parse(response.getBody().toString());
        JsonObject jsonObject = jElement.getAsJsonObject();
        Assert.assertEquals(2, Integer.parseInt(jsonObject.get("status").toString()));
        Assert.assertNotNull(jsonObject.get("tradeAccount"));
        Assert.assertNotEquals("", jsonObject.get("tradeAccount"));
    }
}