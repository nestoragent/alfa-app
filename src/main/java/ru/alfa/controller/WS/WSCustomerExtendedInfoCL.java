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
@RequestMapping("WSCustomerExtendedInfoCL")
public class WSCustomerExtendedInfoCL {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String getTelephoneNumber(@RequestParam String cus) {
        System.out.println("cus: " + cus);
        JSONObject obj = new JSONObject();
        obj.put("adt", "79852222556");
        return obj.toString();
    }
}
