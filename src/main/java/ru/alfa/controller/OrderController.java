package ru.alfa.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.alfa.model.Order;
import ru.alfa.objects.ServerResponse;
import ru.alfa.requests.RequestRetrofitJson;

import java.io.IOException;

/**
 * Created by nestor on 04.07.2017.
 */
@Slf4j
@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    ResponseEntity<String> postOrder(
            @RequestParam(value = "pins") String pins,
            @RequestParam(value = "assetId") String assetId,
            @RequestParam(value = "generalAgreementId") String generalAgreementId,
            @RequestParam(value = "operation") String operation,
            @RequestParam(value = "quantity") String quantity,
            @RequestParam(value = "amount") String amount,
            @RequestParam(value = "signCode") String signCode,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "dateTime") String dateTime,
            @RequestParam(value = "ref") String reference) {
        if (true) {
            System.out.println("pins: " + pins);
            System.out.println("assetId: " + assetId);
            System.out.println("generalAgreementId: " + generalAgreementId);
            System.out.println("operation: " + operation);
            System.out.println("amount: " + amount);
            System.out.println("quantity: " + quantity);
            System.out.println("signCode: " + signCode);
            System.out.println("phone: " + phone);
            System.out.println("dateTime: " + dateTime);
            System.out.println("reference: " + reference);

            JSONObject obj = new JSONObject();
            obj.put("code", "201");
            obj.put("Description", "покупка прошла успешно");
            return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
        } else {
            ServerResponse serverResponse;
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("status", new JsonPrimitive("Извините, что-то пошло не так, попробуйте позднее"));

            Order order = new Order();
            order.setPins(pins);
            try {
                order.setPins(pins);
                order.setAssetId(Integer.parseInt(assetId));
                order.setGeneralAgreementId(Integer.parseInt(generalAgreementId));
                order.setOperation(Integer.parseInt(operation));
                order.setQuantity(Integer.parseInt(quantity));
                order.setAmount(Integer.parseInt(amount));
                order.setSignCode(Integer.parseInt(signCode));
                order.setPhone(phone);
                order.setDateTime(dateTime);
                order.setReference(reference);

                serverResponse = RequestRetrofitJson.getInstance().postOrder(order);
                HttpStatus status = RequestRetrofitJson.getInstance().getResponseCode(serverResponse.getCode());
                String response;
                if (HttpStatus.OK.equals(status)) {
                    response = serverResponse.getJsonMessage();
                } else{
                    response = jsonObject.toString();
                }
                return ResponseEntity.status(status).body(response);
                
            } catch (NumberFormatException e) {
                log.info("Error message: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
            } catch (IOException e) {
                log.debug("[ERROR]", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonObject.toString());
            }
        }
    }
}
