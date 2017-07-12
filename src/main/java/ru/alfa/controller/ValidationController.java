package ru.alfa.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public @ResponseBody
    ResponseEntity postOrderValidation(String orderValidationBody) {
        if (true) {
            System.out.println("orderValidationBody: " + orderValidationBody);           

            JsonObject jsonObject = new JsonObject();
            jsonObject.add("serverError", new JsonPrimitive(""));
            jsonObject.add("alfaResponse", new JsonPrimitive("{\"status\":2,\"message\":\"Лимиты рассчитаны\",\"tradeAccount\":\"30601840700009092110\",\"commissionAccount\":\"30601810400009092110\",\"missingForTrade\":0.0000,\"missingForCommission\":0.0000,\"amount\":0.00000000,\"quantity\":0,\"commission\":0.0000,\"generalAgreementId\":92110}"));
            return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
        } else {
            String response = "";
            String serverError = "";
            int status;
            JsonObject jsonObject = new JsonObject();

            try {
                Gson gson = new Gson();
                OrderValidation orderValidation = gson.fromJson(orderValidationBody, OrderValidation.class);
                orderValidation.setAttachmentName("");
                orderValidation.setAttachmentBody("");

                ServerResponse serverResponse = RequestRetrofitJson.getInstance().postOrderValidation(orderValidation);
                status = serverResponse.getCode();
                response = serverResponse.getJsonMessage();

            } catch (NumberFormatException e) {
                log.info("Error message: " + e.getMessage());
                serverError = e.getMessage();
                status = 400;
            }catch (NullPointerException e){
                serverError = e.getMessage();
                status = 400;
            } catch (IOException e) {
                log.debug("[ERROR]", e);
                serverError = e.getMessage();
                status = 503;
            } 

            jsonObject.add("serverError", new JsonPrimitive(serverError));
            jsonObject.add("alfaResponse", new JsonPrimitive(response));
            return ResponseEntity.status(status).body(jsonObject.toString());
        }
    }
}
