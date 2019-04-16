package com.example.event.consumer.model;

import lombok.Data;

import java.util.Date;

@Data
public class Checkin {

    private String customer;

    private Date checkinDate;
}
