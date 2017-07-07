package ru.alfa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.alfa.objects.ServerResponse;
import ru.alfa.requests.RequestRetrofitJson;

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
    ResponseEntity postAssetsById(@RequestParam String id) {
        if (true) {
            return ResponseEntity.status(HttpStatus.OK).body("{\n" +
                    "    \"aci\": 11.69,\n" +
                    "    \"aciTotal\": 0,\n" +
                    "    \"activity\": 1,\n" +
                    "    \"buyPrice\": 176.33,\n" +
                    "    \"coupon\": 12.75,\n" +
                    "    \"couponPeriod\": 180,\n" +
                    "    \"paymentsTotal\": 0,\n" +
                    "    \"duration\": 7.1,\n" +
                    "    \"isin\": \"XS0088543193\",\n" +
                    "    \"maturityDate\": \"2028-06-24T00:00:00.0000000-07:00\",\n" +
                    "    \"name\": \"Еврообл РФ28 XS0088543193\",\n" +
                    "    \"tradePlace\": \"\",\n" +
                    "    \"nominalCurrency\": \"USD\",\n" +
                    "    \"nominalCurrencyValue\": 0,\n" +
                    "    \"nominal\": 1000,\n" +
                    "    \"priceCurrency\": \"%\",\n" +
                    "    \"quantity\": 0,\n" +
                    "    \"registryNumber\": \"MK-0-CM-119\",\n" +
                    "    \"sellPrice\": 178.05,\n" +
                    "    \"ticker\": \"MF0628XS\",\n" +
                    "    \"toolType\": \"\",\n" +
                    "    \"ytm\": 3.97,\n" +
                    "    \"id\": 2237,\n" +
                    "    \"expense\": 0,\n" +
                    "    \"grossIncome\": 0,\n" +
                    "    \"yield\": 0,\n" +
                    "    \"holdingTotalDays\": 0,\n" +
                    "    \"qualifiedOnly\": true,\n" +
                    "    \"currentValue\": null\n" +
                    "}\n");
        } else {
            ServerResponse serverResponse;
            try {
                serverResponse = RequestRetrofitJson.getInstance().getAssetsIdRequest(id);
                log.info("Done request for get assets by id. Server code respose: " + serverResponse.getCode());
            } catch (Exception e) {
                log.debug("[ERROR]", e);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(serverResponse.getJsonMessage());

        }
    }

}
