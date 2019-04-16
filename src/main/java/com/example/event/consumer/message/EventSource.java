package com.example.event.consumer.message;

import com.example.event.consumer.model.Checkin;
import com.example.event.consumer.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Sink.class)
@AllArgsConstructor
public class EventSource {


    @StreamListener(Sink.INPUT)
    public void processMessage(Event event) {
        Checkin checkin = new ObjectMapper().convertValue(event.getData(),Checkin.class);
        System.out.println("Got checkin for: "+checkin.getCustomer());
    }
}
