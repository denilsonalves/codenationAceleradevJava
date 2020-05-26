package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService service;

    @Autowired
    private SubmissionMapper mapper;

    @GetMapping
    public ResponseEntity<List<SubmissionDTO>> findByChallengeIdAndAccelerationId(@RequestParam Long challengeId, @RequestParam Long accelerationId) {
        List<SubmissionDTO> dto = service
                .findByChallengeIdAndAccelerationId(challengeId, accelerationId)
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dto);
    }
}
