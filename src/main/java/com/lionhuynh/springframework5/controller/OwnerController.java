package com.lionhuynh.springframework5.controller;

import com.lionhuynh.springframework5.model.Owner;
import com.lionhuynh.springframework5.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping("/all")
    public ResponseEntity<Set<Owner>> getAll(){
        return new ResponseEntity<>(ownerService.findAll(), HttpStatus.OK);
    }
}
