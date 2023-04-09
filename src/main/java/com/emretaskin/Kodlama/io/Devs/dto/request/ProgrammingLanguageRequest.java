package com.emretaskin.Kodlama.io.Devs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProgrammingLanguageRequest {
    private String name;
}
