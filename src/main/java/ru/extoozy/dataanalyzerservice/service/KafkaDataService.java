package ru.extoozy.dataanalyzerservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.extoozy.dataanalyzerservice.model.Data;
import ru.extoozy.dataanalyzerservice.repository.DataRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataService implements DataService {

    private final DataRepository dataRepository;

    public void handle(Data data){
        dataRepository.save(data);
        log.info("Data object {} was saved", data);
    }
}
