package ru.extoozy.datastoreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.extoozy.datastoreservice.model.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
