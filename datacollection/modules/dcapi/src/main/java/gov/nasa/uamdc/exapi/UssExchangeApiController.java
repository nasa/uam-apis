package gov.nasa.uamdc.exapi;

import gov.nasa.uamdc.model.USSExchange;
import gov.nasa.uamdc.model.UTMRestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-12T14:35:36.103-08:00[America/Los_Angeles]")
@Controller
public class UssExchangeApiController implements UssExchangeApi {

    private static final Logger log = LoggerFactory.getLogger(UssExchangeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UssExchangeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<UTMRestResponse> ussExchangePost(@ApiParam(value = "Upload an array of models" ,required=true )  @Valid @RequestBody List<USSExchange> body) {
        String accept = request.getHeader("Accept");
        UTMRestResponse restResponse = null;
        if (accept != null && accept.contains("application/json")) {
            try {

                return new ResponseEntity<UTMRestResponse>(
                        objectMapper.readValue("{\n  \"http_status_code\" : 139,\n  \"message\" : \"{\"http_status_code\":400,\"message\":\"Bad Request. Invalid JSON?\"}\"\n}",

                                UTMRestResponse.class),

                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UTMRestResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UTMRestResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
