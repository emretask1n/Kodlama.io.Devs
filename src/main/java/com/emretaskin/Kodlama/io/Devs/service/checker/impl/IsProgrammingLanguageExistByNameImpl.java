package com.emretaskin.Kodlama.io.Devs.service.checker.impl;

import com.emretaskin.Kodlama.io.Devs.entity.ProgrammingLanguage;
import com.emretaskin.Kodlama.io.Devs.exception.ProgrammingLanguageAlreadyExistsException;
import com.emretaskin.Kodlama.io.Devs.repository.ProgrammingLanguageRepository;

import com.emretaskin.Kodlama.io.Devs.service.checker.interfaces.IsProgrammingLanguageExistByName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class IsProgrammingLanguageExistByNameImpl implements IsProgrammingLanguageExistByName {
    private final ProgrammingLanguageRepository programmingLanguageRepository;
    @Override
    public void check(String name) {
        Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageRepository.findByName(name);
        if(programmingLanguage.isPresent()){
            throw new ProgrammingLanguageAlreadyExistsException("Programming Language already exists with name : " + name);
        }
    }
}
