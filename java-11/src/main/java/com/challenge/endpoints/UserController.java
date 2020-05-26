package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @GetMapping
    public ResponseEntity<List<User>> findByAccelerationNameOrCompanyId(
            @RequestParam(required = false) String accelerationName,
            @RequestParam(required = false) Long companyId){

        if(accelerationName != null)
            return ResponseEntity.ok(service.findByAccelerationName(accelerationName));

        if(companyId != null)
            return ResponseEntity.ok(service.findByCompanyId(companyId));

        return ResponseEntity.notFound().build();
    }
}
