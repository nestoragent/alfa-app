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
public class AssetsControllerTest {

    @Test
    public void positiveTestMakePostAssetsById() throws Exception {
        //arrange
        AssetsController assetsController = new AssetsController();

        //act
        ResponseEntity response = assetsController.postAssetsById("1");

        //assert
        JsonElement jElement = new JsonParser().parse(response.getBody().toString());
        JsonObject jsonObject = jElement.getAsJsonObject();
        Assert.assertNotEquals("", jsonObject.get("ticker"));
        Assert.assertNotNull(jsonObject.get("ticker"));
        Assert.assertNotEquals("", jsonObject.get("buyPrice"));
        Assert.assertNotNull(jsonObject.get("buyPrice"));
    }
}