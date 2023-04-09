package com.emretaskin.Kodlama.io.Devs.service.interfaces;

import com.emretaskin.Kodlama.io.Devs.dto.request.ProgrammingLanguageRequest;
import com.emretaskin.Kodlama.io.Devs.dto.response.ProgrammingLanguageResponse;
import com.emretaskin.Kodlama.io.Devs.entity.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    List<ProgrammingLanguageResponse> listAllProgrammingLanguageNames();

    ProgrammingLanguageResponse getProgrammingLanguageNameById(Long id);

    ProgrammingLanguageResponse createProgrammingLanguage(ProgrammingLanguageRequest programmingLanguageRequest);

    ProgrammingLanguageResponse deleteProgrammingLanguageById(Long id);

    ProgrammingLanguageResponse updateProgrammingLanguage(Long id, ProgrammingLanguageRequest programmingLanguageRequest);

    ProgrammingLanguage findProgrammingLanguageById(Long id);
}
