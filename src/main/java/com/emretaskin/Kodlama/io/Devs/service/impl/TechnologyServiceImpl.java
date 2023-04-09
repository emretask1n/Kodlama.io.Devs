package com.emretaskin.Kodlama.io.Devs.service.impl;

import com.emretaskin.Kodlama.io.Devs.dto.request.TechnologyRequest;
import com.emretaskin.Kodlama.io.Devs.dto.response.TechnologyResponse;
import com.emretaskin.Kodlama.io.Devs.entity.ProgrammingLanguage;
import com.emretaskin.Kodlama.io.Devs.entity.Technology;
import com.emretaskin.Kodlama.io.Devs.repository.TechnologyRepository;
import com.emretaskin.Kodlama.io.Devs.service.checker.interfaces.IsProgrammingLanguageExistById;
import com.emretaskin.Kodlama.io.Devs.service.checker.interfaces.IsStringBlank;
import com.emretaskin.Kodlama.io.Devs.service.checker.interfaces.IsTechnologyExistById;
import com.emretaskin.Kodlama.io.Devs.service.interfaces.ProgrammingLanguageService;
import com.emretaskin.Kodlama.io.Devs.service.interfaces.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {
    private final ProgrammingLanguageService programmingLanguageService;
    private final TechnologyRepository technologyRepository;
    private final IsStringBlank isStringBlank;
    private final IsTechnologyExistById isTechnologyExistById;
    private final IsProgrammingLanguageExistById isProgrammingLanguageExistById;
    @Override
    public String saveTechnology(TechnologyRequest technologyRequest) {
        isStringBlank.check(technologyRequest.getName());

        ProgrammingLanguage programmingLanguage = programmingLanguageService.findProgrammingLanguageById(technologyRequest.getProgrammingLanguageId());

        technologyRepository.save(Technology.builder().name(technologyRequest.getName()).programmingLanguage(programmingLanguage).build());

        return "Technology " + technologyRequest.getName() + "has been saved successfully.";
    }

    @Override
    public String deleteTechnology(Long id) {
        isTechnologyExistById.check(id);
        technologyRepository.deleteById(id);

        return "Technology with id : " + id + "has been deleted successfully.";
    }

    @Override
    public List<TechnologyResponse> listAllTechnologies() {
        List<Technology> technologies = technologyRepository.findAll();

        return technologies.stream()
                .map(technology -> {
                    TechnologyResponse technologyResponse = new TechnologyResponse();
                    technologyResponse.setTechnology(technology.getName());
                    technologyResponse.setProgrammingLanguage(technology.getProgrammingLanguage().getName());
                    return technologyResponse;
                }).toList();
    }

    @Override
    public TechnologyResponse getTechnology(Long id) {
        isTechnologyExistById.check(id);
        Technology technology = technologyRepository.findById(id).get();

        return TechnologyResponse.builder()
                .technology(technology.getName()).
                programmingLanguage(technology.getProgrammingLanguage().getName())
                .build();
    }

    @Override
    public TechnologyResponse updateTechnology(Long id,TechnologyRequest technologyRequest) {
        isTechnologyExistById.check(id);
        isProgrammingLanguageExistById.check(technologyRequest.getProgrammingLanguageId());
        isStringBlank.check(technologyRequest.getName());

        ProgrammingLanguage programmingLanguage = programmingLanguageService.findProgrammingLanguageById(technologyRequest.getProgrammingLanguageId());

        Technology technology = technologyRepository.findById(id).get();
        technology.setName(technologyRequest.getName());
        technology.setProgrammingLanguage(programmingLanguage);

        technologyRepository.save(technology);

        return TechnologyResponse.builder().technology(technology.getName())
                .programmingLanguage(programmingLanguage.getName())
                .build();
    }

}
