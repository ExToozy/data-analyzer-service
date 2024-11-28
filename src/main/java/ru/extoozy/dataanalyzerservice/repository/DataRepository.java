package ru.extoozy.dataanalyzerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.dataanalyzerservice.model.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
