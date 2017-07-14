package ru.alfa.controller.WS;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
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
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.add("adt", new JsonPrimitive("79852222556"));            
            jsonObject.add("serverError", new JsonPrimitive(""));
            jsonObject.add("alfaResponse", jsonResponse);
            jsonObject.add("ref", new JsonPrimitive("PC30407170008szz"));
            return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
        } else {   
             String serverError = "";
            HttpStatus status = HttpStatus.OK;
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonResponse = new JsonObject();
            try {
                String phone = new GetterClientPhone(cus).getPhone();                
                jsonObject.add("adt", new JsonPrimitive(phone));
                ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
            } catch (Exception ex) {
                Logger.getLogger(WSCustomerExtendedInfoCL.class.getName()).log(Level.WARNING, null, ex);
                status = HttpStatus.BAD_REQUEST;
                serverError = ex.getMessage();
            }
            jsonObject.add("serverError", new JsonPrimitive(serverError));
            jsonObject.add("alfaResponse", jsonResponse);
            return ResponseEntity.status(status).body(jsonObject.toString());
        }
    }
}
