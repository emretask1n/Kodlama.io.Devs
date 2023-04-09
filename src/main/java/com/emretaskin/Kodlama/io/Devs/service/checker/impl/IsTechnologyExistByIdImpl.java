package com.emretaskin.Kodlama.io.Devs.service.checker.impl;

import com.emretaskin.Kodlama.io.Devs.repository.TechnologyRepository;
import com.emretaskin.Kodlama.io.Devs.service.checker.interfaces.IsTechnologyExistById;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IsTechnologyExistByIdImpl implements IsTechnologyExistById {
    private final TechnologyRepository technologyRepository;
    @Override
    public void check(Long id) {
        technologyRepository.findById(id);

    }
}
