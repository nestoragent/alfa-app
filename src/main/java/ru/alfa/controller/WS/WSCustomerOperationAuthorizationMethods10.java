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
@RequestMapping("WSCustomerOperationAuthorizationMethods10")
public class WSCustomerOperationAuthorizationMethods10 {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String getTelephoneNumber(
            @RequestParam(value = "cus", required = false, defaultValue = "B81206") String cus,
            @RequestParam(value = "xm", required = true, defaultValue = "NF") String xm,
            @RequestParam(value = "typ", required = true, defaultValue = "PC3") String typ,
            @RequestParam(value = "name", required = true, defaultValue = "PHCL") String name,
            @RequestParam(value = "value", required = true) String value) {
        System.out.println("cus: " + cus);
        System.out.println("xm: " + xm);
        System.out.println("typ: " + typ);
        System.out.println("name: " + name);
        System.out.println("value: " + value);
        JSONObject obj = new JSONObject();
        obj.put("ref", "PC30407170008szz");
        return obj.toString();
    }
}
