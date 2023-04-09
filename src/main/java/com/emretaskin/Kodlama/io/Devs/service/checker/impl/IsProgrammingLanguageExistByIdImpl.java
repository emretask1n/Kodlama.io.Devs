package com.emretaskin.Kodlama.io.Devs.service.checker.impl;

import com.emretaskin.Kodlama.io.Devs.entity.ProgrammingLanguage;
import com.emretaskin.Kodlama.io.Devs.exception.NotFoundException;
import com.emretaskin.Kodlama.io.Devs.repository.ProgrammingLanguageRepository;
import com.emretaskin.Kodlama.io.Devs.service.checker.interfaces.IsProgrammingLanguageExistById;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class IsProgrammingLanguageExistByIdImpl implements IsProgrammingLanguageExistById {

    private final ProgrammingLanguageRepository programmingLanguageRepository;
    @Override
    public void check(Long id) {
        Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findById(id);

        if(programmingLanguage.isEmpty()){
            throw new NotFoundException("Programming Language is not found with id : " + id);
        }

    }
}
