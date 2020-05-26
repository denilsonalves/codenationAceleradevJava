package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @Autowired
    private CandidateMapper mapper;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable Long userId, @PathVariable Long companyId, @PathVariable Long accelerationId) {
        Candidate response = service.findById(userId, companyId, accelerationId).orElseThrow(() -> new RuntimeException());
        return ResponseEntity.ok(mapper.map(response));

    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> findByAccelerationIdOrCompanyId(@RequestParam(required = false) Long accelerationId, @RequestParam(required = false) Long companyId) {
        List<CandidateDTO> dto = new ArrayList<>();

        if (accelerationId != null)
            return ResponseEntity.ok(toDTO(service.findByAccelerationId(accelerationId)));

        if (companyId != null)
            return ResponseEntity.ok(toDTO(service.findByCompanyId(companyId)));
        return ResponseEntity.notFound().build();
    }

    private List<CandidateDTO> toDTO(List<Candidate> candidates) {
        return candidates.stream().map(mapper::map).collect(Collectors.toList());
    }

}
