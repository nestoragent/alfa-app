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
            @RequestParam(value = "assetId") Integer assetId,
            @RequestParam(value = "generalAgreementId") Integer generalAgreementId,
            @RequestParam(value = "operation") Integer operation,
            @RequestParam(value = "quantity") Integer quantity,
            @RequestParam(value = "attachmentName") String attachmentName,
            @RequestParam(value = "amount") Integer amount) {
        ServerResponse response;
        try {
            response = RequestRetrofitJson.getInstance().postOrderValidation(
                    OrderValidation.builder().pins(pins).assetId(assetId)
                            .generalAgreementId(generalAgreementId).operation(operation).quantity(quantity).
                            attachmentName(attachmentName).amount(amount).build());
            log.info("Done request for get assets by id. response: " + response.getJsonMessage());
        } catch (IOException e) {
            log.debug("[ERROR]", e);
            return "Error when call postOrderValidation. Message: " + e.getMessage();
        }
        return response.getJsonMessage();
    }


}
