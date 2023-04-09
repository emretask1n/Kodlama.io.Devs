package com.emretaskin.Kodlama.io.Devs.service.impl;


import com.emretaskin.Kodlama.io.Devs.dto.request.ProgrammingLanguageRequest;
import com.emretaskin.Kodlama.io.Devs.dto.response.ProgrammingLanguageResponse;
import com.emretaskin.Kodlama.io.Devs.entity.ProgrammingLanguage;
import com.emretaskin.Kodlama.io.Devs.repository.ProgrammingLanguageRepository;
import com.emretaskin.Kodlama.io.Devs.service.checker.interfaces.IsProgrammingLanguageExistById;
import com.emretaskin.Kodlama.io.Devs.service.checker.interfaces.IsProgrammingLanguageExistByName;
import com.emretaskin.Kodlama.io.Devs.service.checker.interfaces.IsStringBlank;
import com.emretaskin.Kodlama.io.Devs.service.interfaces.ProgrammingLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageServiceImpl implements ProgrammingLanguageService {
    private final ProgrammingLanguageRepository programmingLanguageRepository;
    private final IsProgrammingLanguageExistById isProgrammingLanguageExistById;
    private final IsStringBlank isStringBlank;
    private final IsProgrammingLanguageExistByName isProgrammingLanguageExistByName;

    @Override
    public List<ProgrammingLanguageResponse> listAllProgrammingLanguageNames() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();

        return programmingLanguages.stream()
                .map(programmingLanguage -> ProgrammingLanguageResponse.builder().name(programmingLanguage.getName()).build())
                .toList();
    }

    @Override
    public ProgrammingLanguageResponse getProgrammingLanguageNameById(Long id) {
        isProgrammingLanguageExistById.check(id);
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
        return ProgrammingLanguageResponse.builder().name(programmingLanguage.getName())
                .build();
    }

    @Override
    public ProgrammingLanguageResponse createProgrammingLanguage(ProgrammingLanguageRequest programmingLanguageRequest) {
        isProgrammingLanguageExistByName.check(programmingLanguageRequest.getName());
        isStringBlank.check(programmingLanguageRequest.getName());

        ProgrammingLanguage programmingLanguage = ProgrammingLanguage.builder()
                .name(programmingLanguageRequest.getName())
                .build();

        programmingLanguageRepository.save(programmingLanguage);

        return ProgrammingLanguageResponse.builder().name(programmingLanguageRequest.getName() + " is created").build();
    }

    @Override
    public ProgrammingLanguageResponse deleteProgrammingLanguageById(Long id) {
        isProgrammingLanguageExistById.check(id);

        programmingLanguageRepository.deleteById(id);

        return ProgrammingLanguageResponse.builder().name("Deleted by id : " + id).build();
    }

    @Override
    public ProgrammingLanguageResponse updateProgrammingLanguage(Long id, ProgrammingLanguageRequest programmingLanguageRequest) {
        isStringBlank.check(programmingLanguageRequest.getName());

        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();

        programmingLanguage.setName(programmingLanguageRequest.getName());

        programmingLanguageRepository.save(programmingLanguage);

        return ProgrammingLanguageResponse.builder().name("Language with id : " + programmingLanguage.getId() + " is updated as " + programmingLanguage.getName()).build();
    }

    @Override
    public ProgrammingLanguage findProgrammingLanguageById(Long id) {
        isProgrammingLanguageExistById.check(id);

        return programmingLanguageRepository.findById(id).get();
    }
}
