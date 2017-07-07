package ru.alfa.controller.WS;

import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.alfa.getters.GetterPipeOperation;
import ru.alfa.objects.pipe.AuthOutParms;

/**
 * Created by nestor on 05.07.2017.
 */
@Slf4j
@Controller
@RequestMapping("WSCustomerOperationAuthorizationMethods10")
public class WSCustomerOperationAuthorizationMethods10 {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    ResponseEntity createPipeOperation(
            @RequestParam(value = "cus", required = false, defaultValue = "B81206") String cus,
            @RequestParam(value = "xm", required = true, defaultValue = "NF") String xm,
            @RequestParam(value = "typ", required = true, defaultValue = "PC3") String typ,
            @RequestParam(value = "name", required = true, defaultValue = "PHCL") String name,
            @RequestParam(value = "value", required = true) String value) {
        if (true) {
            System.out.println("cus: " + cus);
            System.out.println("xm: " + xm);
            System.out.println("typ: " + typ);
            System.out.println("name: " + name);
            System.out.println("value: " + value);
            JSONObject obj = new JSONObject();
            obj.put("ref", "PC30407170008szz");
            return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
        } else {            
            try {
                AuthOutParms authOutParms = new GetterPipeOperation(cus, xm, typ, name, value).getRefCode();
                if (authOutParms != null) {
                    JSONObject obj = new JSONObject();
                    obj.put("ref", authOutParms.getRef());
                    return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
                }
            } catch (Exception ex) {
                Logger.getLogger(WSCustomerOperationAuthorizationMethods10.class.getName()).log(Level.WARNING, null, ex);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
