package com.emretaskin.Kodlama.io.Devs.service.interfaces;

import com.emretaskin.Kodlama.io.Devs.dto.request.TechnologyRequest;
import com.emretaskin.Kodlama.io.Devs.dto.response.TechnologyResponse;

import java.util.List;

public interface TechnologyService {
    String saveTechnology(TechnologyRequest technologyRequest);

    String deleteTechnology(Long id);


    List<TechnologyResponse> listAllTechnologies();

    TechnologyResponse getTechnology(Long id);

    TechnologyResponse updateTechnology(Long id, TechnologyRequest technologyRequest);
}
