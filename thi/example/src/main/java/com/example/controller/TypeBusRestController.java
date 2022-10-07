package com.example.controller;

import com.example.model.bus.TypeBus;
import com.example.service.ITypeBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("typeBus")
public class TypeBusRestController {
    @Autowired
    private ITypeBusService typeBusService;

    @GetMapping("")
    public ResponseEntity<List<TypeBus>> findAll(){
        List<TypeBus> typeBusList = typeBusService.listTypeBus();
        if (typeBusList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeBusList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeBus> findById(@PathVariable Long id){
        TypeBus typeBus = typeBusService.findTypeBusById(id);
        if (typeBus == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeBus, HttpStatus.OK);
    }
}
