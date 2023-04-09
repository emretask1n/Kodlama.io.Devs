package com.emretaskin.Kodlama.io.Devs.controller;

import com.emretaskin.Kodlama.io.Devs.dto.request.TechnologyRequest;
import com.emretaskin.Kodlama.io.Devs.dto.response.TechnologyResponse;
import com.emretaskin.Kodlama.io.Devs.service.interfaces.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/v2/technology")
@RequiredArgsConstructor
public class TechnologyController {
    private final TechnologyService technologyService;

    @PostMapping
    public ResponseEntity<String> createTechnology(@RequestBody TechnologyRequest technologyRequest){
        return new ResponseEntity<>(technologyService.saveTechnology(technologyRequest), CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTechnology(@PathVariable Long id){
        return new ResponseEntity<>(technologyService.deleteTechnology(id), OK);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponse>> listAllTechnologies(){
        return new ResponseEntity<>(technologyService.listAllTechnologies(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologyResponse> getTechnology(@PathVariable Long id){
        return new ResponseEntity<>(technologyService.getTechnology(id), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyResponse> updateTechnology(@PathVariable Long id, @RequestBody TechnologyRequest technologyRequest){
        return new ResponseEntity<>(technologyService.updateTechnology(id, technologyRequest), OK);
    }


}
