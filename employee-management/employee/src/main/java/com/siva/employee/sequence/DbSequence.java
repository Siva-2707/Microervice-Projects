package com.siva.employee.sequence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class DbSequence {
    @Id
    private String id;
    private int seq;
}
