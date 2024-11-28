package ru.extoozy.dataanalyzerservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;
import ru.extoozy.dataanalyzerservice.model.Data;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaDataReceiver implements DataReceiver {

    private final DataService dataService;

    private final KafkaReceiver<String, Object> receiver;

    private final ObjectMapper mapper;


    @PostConstruct
    private void init(){
        fetch();
    }

    @Override
    public void fetch() {
        receiver.receive()
                .subscribe(r -> {
                    try {
                        Data o = mapper.readerFor(Data.class).readValue(r.value().toString());
                        dataService.handle(o);
                        r.receiverOffset().acknowledge();
                    } catch (JsonProcessingException e) {
                        log.error("Error while fetch message: ", e);
                    }
                });
    }


}
