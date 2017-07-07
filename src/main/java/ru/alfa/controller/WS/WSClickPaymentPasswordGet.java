package ru.alfa.controller.WS;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nestor on 05.07.2017.
 */
@Slf4j
@Controller
@RequestMapping("WSClickPaymentPasswordGet")
public class WSClickPaymentPasswordGet {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String sendSMS(
            @RequestParam(value = "ref", required = true) String ref,
            @RequestParam(value = "methodCode", required = true, defaultValue = "SMSPWD") String methodCode
    ) {
        System.out.println("ref: " + ref);
        System.out.println("methodCode: " + methodCode);
        JSONObject obj = new JSONObject();
        obj.put("ref", "PC30407170008szz");
        return obj.toString();
    }
}
