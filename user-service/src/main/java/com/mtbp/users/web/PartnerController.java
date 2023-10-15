package com.mtbp.users.web;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import com.mtbp.commons.dto.users.PartnerDto;
import com.mtbp.commons.dto.users.UpdatePartnerRequest;
import com.mtbp.users.services.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerService partnerService;

    @PostMapping
    public ResponseEntity<PartnerDto> addPartner(@RequestBody AddPartnerRequest addPartnerRequest) {
        PartnerDto partner = partnerService.addPartner(addPartnerRequest);
        URI location = UriHelperUtils.createUriFrom(PartnerController.class, "partners", partner.getId());
        return ResponseEntity.created(location).body(partner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartnerDto> updatePartner(@PathVariable String id, @RequestBody UpdatePartnerRequest updatePartnerRequest) {
        PartnerDto customer = partnerService.updatePartner(id, updatePartnerRequest);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerDto> findPartner(@PathVariable String id) {
        PartnerDto partner = partnerService.findPartner(id);
        return ResponseEntity.ok(partner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePartner(@PathVariable String id) {
        if (partnerService.deletePartner(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}