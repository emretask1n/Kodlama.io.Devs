package com.emretaskin.Kodlama.io.Devs.repository;

import com.emretaskin.Kodlama.io.Devs.entity.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {

    List<ProgrammingLanguage> findAll();

    Optional<ProgrammingLanguage> findByName(String name);
}
