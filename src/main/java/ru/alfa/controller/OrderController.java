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
import ru.alfa.model.Order;
import ru.alfa.objects.ServerResponse;
import ru.alfa.requests.RequestRetrofitJson;

import java.io.IOException;
import java.util.Calendar;
import ru.alfa.tools.StringFormatter;

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
            System.out.println("reference: " + reference);

            JsonObject jsonObject = new JsonObject();
            jsonObject.add("serverError", new JsonPrimitive(""));
            jsonObject.add("alfaResponse", new JsonPrimitive("{\n"
                    + "  \"Error\": 0,\n"
                    + "  \"Message\": \"покупка прошла успешно\",\n"
                    + "  \"Result\": 0,\n"
                    + "  \"Success\": true\n"
                    + "}"));            
            return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
        } else {
            String response = "";
            String serverError = "";
            int status;
            JsonObject jsonObject = new JsonObject();

            try {
                Order order = new Order();
                order.setPins(pins);
                order.setPins(pins);
                order.setAssetId(Integer.parseInt(assetId));
                order.setGeneralAgreementId(Integer.parseInt(generalAgreementId));
                order.setOperation(Integer.parseInt(operation));
                order.setQuantity(Integer.parseInt(quantity));
                order.setAmount(Integer.parseInt(amount));
                order.setSignCode(Integer.parseInt(signCode));
                order.setPhone(phone);
                order.setReference(reference);

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                StringFormatter formatter = new StringFormatter();
                order.setDateTime(formatter.dateFormat(calendar.get(Calendar.DAY_OF_MONTH),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR))
                        + " " + formatter.timeFormat(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)));

                ServerResponse serverResponse = RequestRetrofitJson.getInstance().postOrder(order);
                status = serverResponse.getCode();
                response = serverResponse.getJsonMessage();

            } catch (NumberFormatException e) {
                log.info("Error message: " + e.getMessage());
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
