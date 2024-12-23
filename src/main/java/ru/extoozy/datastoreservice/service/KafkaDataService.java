package ru.extoozy.datastoreservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.extoozy.datastoreservice.model.Data;
import ru.extoozy.datastoreservice.repository.DataRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataService implements DataService {

    private final DataRepository dataRepository;

    public void handle(Data data){
        Data saved = dataRepository.save(data);
        log.info("Data object {} saved", saved);
    }
}
