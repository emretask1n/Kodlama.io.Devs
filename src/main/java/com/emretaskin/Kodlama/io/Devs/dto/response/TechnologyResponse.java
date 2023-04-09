package com.emretaskin.Kodlama.io.Devs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyResponse {
    private String programmingLanguage;
    private String technology;
}
