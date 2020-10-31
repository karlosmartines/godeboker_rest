package java.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.dto.BestillingDto;
import service.BokService;

@RestController
@RequestMapping("/godbok/")
public class BokController {
    private final BokService bokService;
    @Autowired
    public BokController(BokService bokService) {
        this.bokService = bokService;
    }

    @PostMapping(value = "/bestill", consumes = "application/json")
    public ResponseEntity<BestillingDto> bestill(@RequestBody BestillingDto bestillingDto){
        Integer response = bokService.bestill(bestillingDto);
        return new ResponseEntity<>();
    }
}
