package com.emretaskin.Kodlama.io.Devs.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TechnologyRequest {
    private String name;
    private Long programmingLanguageId;
}
