package com.example.cloudstream.service;

import com.example.cloudstream.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@EnableBinding(Processor.class)
@MessageEndpoint
@Service
public class StreamHandlerService {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Book updateBook(Book receivedBook) throws Exception {
        log.info("updateBook: " + receivedBook);
        receivedBook.setStatus("checked");
        return receivedBook;
        // return Book.builder()
        //         .id(receivedBook.getId())
        //         .name(receivedBook.getName())
        //         .description(receivedBook.getDescription())
        //         .status("checked")
        //         .price(receivedBook.getPrice())
        //         .build();
    }
}
