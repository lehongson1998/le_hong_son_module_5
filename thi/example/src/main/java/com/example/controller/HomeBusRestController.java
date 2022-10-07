package com.example.controller;

import com.example.model.bus.HomeBus;
import com.example.service.IHomeBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/bus")
public class HomeBusRestController {
    @Autowired
    private IHomeBusService homeBusService;

    @GetMapping("")
    public ResponseEntity<Page<HomeBus>> findAll(@RequestParam Optional<String> name,
                                                 @PageableDefault(size = 3)Pageable pageable){
        String name1 = name.orElse("");
        Page<HomeBus> homeBusList = homeBusService.listHomeBus("%" + name1 + "%", pageable);
        if (!homeBusList.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homeBusList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeBus> findHomeBusById(@PathVariable String id){
        HomeBus homeBus = homeBusService.findHomeBusById(id);
        if (homeBus == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homeBus, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Void> saveHomeBus(@RequestBody HomeBus homeBus){
        homeBusService.save(homeBus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<Void> update(@RequestBody HomeBus homeBus){
        if (homeBus == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            homeBusService.update(homeBus);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        if (id == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        homeBusService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
