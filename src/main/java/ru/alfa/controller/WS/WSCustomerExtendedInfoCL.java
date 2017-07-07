package ru.alfa.controller.WS;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
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
import ru.alfa.getters.GetterClientPhone;

/**
 * Created by nestor on 05.07.2017.
 */
@Slf4j
@Controller
@RequestMapping("WSCustomerExtendedInfoCL")
public class WSCustomerExtendedInfoCL {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    ResponseEntity getTelephoneNumber(@RequestParam String cus) {
        if (true) {
            System.out.println("cus: " + cus);
            JSONObject obj = new JSONObject();
            obj.put("adt", "79852222556");
            return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
        } else {             
            try {
                String phone = new GetterClientPhone(cus).getPhone();
                JsonObject jsonObject = new JsonObject();
                jsonObject.add("adt", new JsonPrimitive(phone));
                ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
            } catch (Exception ex) {
                Logger.getLogger(WSCustomerExtendedInfoCL.class.getName()).log(Level.WARNING, null, ex);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
