package com.javatechie.aws.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.javatechie.aws.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProfessorRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public String saveProfessorInfo(Professor professor) {
        mapper.save(professor);
        return "Hi " + professor.getName() + " your registration process completed successfully..!! ";
    }

    public Professor findProfessor(String professorId) {
        return mapper.load(Professor.class, professorId);
    }

    public String removeProfessor(Professor professor) {
        mapper.delete(professor);
        return "professor " + professor.getName() + " Removed From DB ..";
    }


    public String editProfessorInfo(Professor professor) {
        mapper.save(professor, buildDynamoDBExpression(professor));
        return "Record updated !!";
    }

    public DynamoDBSaveExpression buildDynamoDBExpression(Professor professor) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("professorId", new ExpectedAttributeValue(new AttributeValue().withS(professor.getProfessorId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }
}
