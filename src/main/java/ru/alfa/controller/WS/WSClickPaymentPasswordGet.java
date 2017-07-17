package ru.alfa.controller.WS;

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
import ru.alfa.getters.SendAndValidCode;
import ru.alfa.objects.OutParms;

/**
 * Created by nestor on 05.07.2017.
 */
@Slf4j
@Controller
@RequestMapping("WSClickPaymentPasswordGet")
public class WSClickPaymentPasswordGet {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    ResponseEntity sendSMS(
            @RequestParam(value = "ref", required = true) String ref,
            @RequestParam(value = "methodCode", required = true, defaultValue = "SMSPWD") String methodCode) {
        if (true) {
            System.out.println("ref: " + ref);
            System.out.println("methodCode: " + methodCode);            
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.add("status", new JsonPrimitive("success"));            
            jsonResponse.add("actionId", new JsonPrimitive(""));
            jsonObject.add("serverError", new JsonPrimitive(""));
            jsonObject.add("alfaResponse", jsonResponse);            
            return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());           
        } else {
            String serverError = "";
            HttpStatus status = HttpStatus.OK;
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonResponse = new JsonObject();
            try {
                OutParms params = new SendAndValidCode(ref, methodCode).sendSMS();
                String actionId = params.getActionId().trim();
                if ("".equals(actionId)) {
                    jsonResponse.add("status", new JsonPrimitive("success"));
                    jsonResponse.add("actionId", new JsonPrimitive(""));
                } else {
                    StringBuilder message = new StringBuilder();
                    message.append("Error code: " + actionId);
                    switch (actionId) {
                        case "ERRLGT1011":
                            message.append("Операция блокирована");
                            break;
                        case "ERRLGT1020":
                            message.append("Метод авторизации не доступен");
                            break;
                        case "ERRCUR1021":
                            message.append("Метод авторизации просрочен");
                            break;
                        case "ERRCUR1012":
                            message.append("Проверка пароля не доступна");
                            break;
                    }
                    jsonResponse.add("status", new JsonPrimitive("fail"));
                    jsonResponse.add("actionId", new JsonPrimitive(message.toString()));
                    status = HttpStatus.INTERNAL_SERVER_ERROR;
                }
            } catch (Exception ex) {
                log.debug("Method sendSMS.", ex);
                status = HttpStatus.BAD_REQUEST;
                serverError = ex.getMessage();
            }
            jsonObject.add("serverError", new JsonPrimitive(serverError));
            jsonObject.add("alfaResponse", jsonResponse);
            return ResponseEntity.status(status).body(jsonObject.toString());
        }
    }
}
