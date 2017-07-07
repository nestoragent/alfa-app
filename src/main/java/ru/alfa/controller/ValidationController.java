package ru.alfa.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.alfa.model.OrderValidation;
import ru.alfa.objects.ServerResponse;
import ru.alfa.requests.RequestRetrofitJson;

import java.io.IOException;

/**
 * Created by nestor on 04.07.2017.
 */
@Slf4j
@Controller
@RequestMapping("order/validation")
public class ValidationController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    ResponseEntity postOrderValidation(
            @RequestParam(value = "pins") String pins,
            @RequestParam(value = "assetId") String assetId,
            @RequestParam(value = "generalAgreementId") String generalAgreementId,
            @RequestParam(value = "operation") String operation,
            @RequestParam(value = "amount") String amount,
            @RequestParam(value = "quantity") String quantity) {
        if (true) {
            System.out.println("pins: " + pins);
            System.out.println("assetId: " + assetId);
            System.out.println("generalAgreementId: " + generalAgreementId);
            System.out.println("operation: " + operation);
            System.out.println("amount: " + amount);
            System.out.println("quantity: " + quantity);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\":2,\"message\":\"Лимиты рассчитаны\",\"tradeAccount\":\"30601840700009092110\",\"commissionAccount\":\"30601810400009092110\",\"missingForTrade\":0.0000,\"missingForCommission\":0.0000,\"amount\":0.00000000,\"quantity\":0,\"commission\":0.0000,\"generalAgreementId\":92110}");
        } else {
            ServerResponse serverResponse;
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("status", new JsonPrimitive("Извините, что-то пошло не так, попробуйте позднее"));

            OrderValidation orderValidation = new OrderValidation();
            orderValidation.setPins(pins);
            try {
                orderValidation.setAssetId(Integer.parseInt(assetId));
                orderValidation.setGeneralAgreementId(Integer.parseInt(generalAgreementId));
                orderValidation.setOperation(Integer.parseInt(operation));
                orderValidation.setAmount(Integer.parseInt(amount));
                orderValidation.setQuantity(Integer.parseInt(quantity));
            } catch (NumberFormatException e) {
                log.info("Error message: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
            }

            try {
                serverResponse = RequestRetrofitJson.getInstance().postOrderValidation(orderValidation);
            } catch (IOException e) {
                log.debug("[ERROR]", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonObject.toString());
            }
            HttpStatus status = RequestRetrofitJson.getInstance().getResponseCode(serverResponse.getCode());
            String response = jsonObject.toString();
            if (HttpStatus.OK.equals(status))
                response = serverResponse.getJsonMessage();
            return ResponseEntity.status(status).body(response);
        }
    }
}
