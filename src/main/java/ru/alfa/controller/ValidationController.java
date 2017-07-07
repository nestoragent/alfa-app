package ru.alfa.controller;

import lombok.extern.slf4j.Slf4j;
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
    String postOrderValidation(
            @RequestParam(value = "pins") String pins,
            @RequestParam(value = "assetId") String assetId,
            @RequestParam(value = "generalAgreementId") String generalAgreementId,
            @RequestParam(value = "operation") String operation,
            @RequestParam(value = "amount") String amount,
            @RequestParam(value = "quantity") String quantity) {
//        ServerResponse response;
//        try {
//            response = RequestRetrofitJson.getInstance().postOrderValidation(
//                    OrderValidation.builder().pins(pins).assetId(assetId)
//                            .generalAgreementId(generalAgreementId).operation(operation).quantity(quantity).
//                            attachmentName(attachmentName).amount(amount).build());
//            log.info("Done request for get assets by id. response: " + response.getJsonMessage());
//        } catch (IOException e) {
//            log.debug("[ERROR]", e);
//            return "Error when call postOrderValidation. Message: " + e.getMessage();
//        }
//        return response.getJsonMessage();
        System.out.println("pins: " + pins);
        System.out.println("assetId: " + assetId);
        System.out.println("generalAgreementId: " + generalAgreementId);
        System.out.println("operation: " + operation);
        System.out.println("amount: " + amount);
        System.out.println("quantity: " + quantity);
        return "{\"status\":2,\"message\":\"Лимиты рассчитаны\",\"tradeAccount\":\"30601840700009092110\",\"commissionAccount\":\"30601810400009092110\",\"missingForTrade\":0.0000,\"missingForCommission\":0.0000,\"amount\":0.00000000,\"quantity\":0,\"commission\":0.0000,\"generalAgreementId\":92110}";
    }


}
