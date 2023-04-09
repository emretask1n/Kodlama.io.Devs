package com.emretaskin.Kodlama.io.Devs.controller;

import com.emretaskin.Kodlama.io.Devs.dto.request.ProgrammingLanguageRequest;
import com.emretaskin.Kodlama.io.Devs.dto.response.ProgrammingLanguageResponse;

import com.emretaskin.Kodlama.io.Devs.service.interfaces.ProgrammingLanguageService;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/languages")
@RequiredArgsConstructor
public class ProgrammingLanguageController {

    private final ProgrammingLanguageService programmingLanguageService;

    @GetMapping
    public ResponseEntity<List<ProgrammingLanguageResponse>> getProgrammingLanguageNames(){
        return new ResponseEntity<>(programmingLanguageService.listAllProgrammingLanguageNames(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammingLanguageResponse> getProgrammingLanguageNameById(@PathVariable Long id){
        return new ResponseEntity<>(programmingLanguageService.getProgrammingLanguageNameById(id), OK);
    }

    @PostMapping
    public ResponseEntity<ProgrammingLanguageResponse> createProgrammingLanguage(@RequestBody ProgrammingLanguageRequest programmingLanguageRequest){
        return new ResponseEntity<>(programmingLanguageService.createProgrammingLanguage(programmingLanguageRequest), CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProgrammingLanguageResponse> deleteProgrammingLanguageById(@PathVariable Long id){
        return new ResponseEntity<>(programmingLanguageService.deleteProgrammingLanguageById(id), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgrammingLanguageResponse> updateProgrammingLanguage(@PathVariable Long id, @RequestBody ProgrammingLanguageRequest programmingLanguageRequest){
        return new ResponseEntity<>(programmingLanguageService.updateProgrammingLanguage(id ,programmingLanguageRequest),OK);
    }


}
