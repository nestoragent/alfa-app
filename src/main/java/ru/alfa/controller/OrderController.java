package ru.alfa.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.alfa.objects.ServerResponse;

/**
 * Created by nestor on 04.07.2017.
 */
@Slf4j
@Controller
@RequestMapping("order/validation")
public class OrderController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String postOrderValidation(
            @RequestParam(value = "pins") String pins,
            @RequestParam(value = "assetId") Integer assetId,
            @RequestParam(value = "generalAgreementId") Integer generalAgreementId,
            @RequestParam(value = "operation") Integer operation,
            @RequestParam(value = "quantity") Integer quantity,
            @RequestParam(value = "amount") Integer amount,
            @RequestParam(value = "reference") String ref) {
        System.out.println("pins: " + pins);
        System.out.println("assetId: " + assetId);
        System.out.println("generalAgreementId: " + generalAgreementId);
        System.out.println("operation: " + operation);
        System.out.println("amount: " + amount);
        System.out.println("quantity: " + quantity);
        System.out.println("reference: " + ref);

        JSONObject obj = new JSONObject();
        obj.put("code", "201");
        obj.put("Description", "покупка прошла успешно");
        return obj.toString();
    }


}
