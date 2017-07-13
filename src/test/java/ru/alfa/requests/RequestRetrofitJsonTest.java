package ru.alfa.requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Retrofit;
import ru.alfa.model.Order;
import ru.alfa.model.OrderValidation;
import ru.alfa.objects.ServerResponse;

import static org.junit.Assert.*;

/**
 * Created by nestor on 13.07.2017.
 */
public class RequestRetrofitJsonTest {

    @Test
    public void positive_testGetAssetsIdRequest() throws Exception {
        //arrange
        //act
        ServerResponse response = RequestRetrofitJson.getInstance().getAssetsIdRequest("1");

        //asserts
        Assert.assertEquals(200, response.getCode());
        JsonElement jElement = new JsonParser().parse(response.getJsonMessage());
        JsonObject jsonObject = jElement.getAsJsonObject();
        Assert.assertEquals("1", jsonObject.get("id"));
    }

    @Test
    public void positive_testPostOrder() throws Exception {
        //arrange
        Order order = new Order();
        order.setPins("string");
        order.setAssetId(0);
        order.setGeneralAgreementId(0);
        order.setOperation(0);
        order.setQuantity(0);
        order.setAttachmentName("string");
        order.setAttachmentBody("string");
        order.setAmount(0);

        //act
        ServerResponse response = RequestRetrofitJson.getInstance().postOrder(order);

        //asserts
        Assert.assertEquals(201, response.getCode());
    }

    @Test
    public void testPostOrderValidation() throws Exception {
        //arrange
        OrderValidation order = new OrderValidation();
        order.setPins("string");
        order.setAssetId(0);
        order.setGeneralAgreementId(0);
        order.setOperation(0);
        order.setQuantity(0);
        order.setAttachmentName("string");
        order.setAttachmentBody("string");
        order.setAmount(0);

        //act
        ServerResponse response = RequestRetrofitJson.getInstance().postOrderValidation(order);

        //asserts
        Assert.assertEquals(201, response.getCode());
    }
}