package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
