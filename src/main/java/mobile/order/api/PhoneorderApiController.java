package mobile.order.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import mobile.order.model.Order;
import mobile.order.model.OrderAmount;
import mobile.order.service.PhoneOrderService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-07T15:38:07.949Z")

@Controller
public class PhoneorderApiController implements PhoneorderApi {

    private static final Logger log = LoggerFactory.getLogger(PhoneorderApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PhoneOrderService phoneOrderService;

    @org.springframework.beans.factory.annotation.Autowired
    public PhoneorderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<OrderAmount> buyPhone(
            @ApiParam(value = "Data of client and phones ordered", required = true) @Valid @RequestBody Order body) {

        try {
            return new ResponseEntity<OrderAmount>(phoneOrderService.buyPhone(body), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<OrderAmount>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
