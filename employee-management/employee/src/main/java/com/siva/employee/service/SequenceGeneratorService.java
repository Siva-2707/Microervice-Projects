package com.siva.employee.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.siva.employee.sequence.DbSequence;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateSequence(String seqName) {
        //Getting Seq number
        Query query = new Query(Criteria.where("id").is(seqName));
        //Updating in Seq table
        Update update = new Update().inc("seq", 1);

        DbSequence count = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
                DbSequence.class);

        return Objects.isNull(count) ? 1 : count.getSeq();

    }

}
