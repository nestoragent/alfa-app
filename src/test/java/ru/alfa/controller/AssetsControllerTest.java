package ru.alfa.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nestor on 05.07.2017.
 */
public class AssetsControllerTest {

    @Test
    public void positiveTestMakePostAssetsById() throws Exception {
        //arrange
        AssetsController assetsController = new AssetsController();

        //act
        String response = assetsController.postAssetsById("1");

        //assert
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONObject jsonObject = (JSONObject) obj;
        Assert.assertNotEquals("", jsonObject.get("ticker"));
        Assert.assertNotNull(jsonObject.get("ticker"));
        Assert.assertNotEquals("", jsonObject.get("buyPrice"));
        Assert.assertNotNull(jsonObject.get("buyPrice"));
    }
}