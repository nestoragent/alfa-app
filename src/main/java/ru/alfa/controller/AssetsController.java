package ru.alfa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.alfa.objects.ServerResponse;
import ru.alfa.requests.RequestRetrofitJson;

import java.io.IOException;

/**
 * Created by nestor on 04.07.2017.
 */
@Slf4j
@Controller
@RequestMapping("assets")
public class AssetsController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String postAssetsById(@RequestParam String id) {
        ServerResponse response;
        try {
            response = RequestRetrofitJson.getInstance().getAssetsIdRequest(id);
            log.info("Done request for get assets by id. response: " + response.getJsonMessage());
        } catch (IOException e) {
            log.debug("[ERROR]", e);
            return "Error when call getAssetsIdRequest. Message: " + e.getMessage();
        }
        return response.getJsonMessage();
    }

}
