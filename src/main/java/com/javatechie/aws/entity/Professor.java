package com.javatechie.aws.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@DynamoDBTable(tableName = "professor")
public class Professor implements Serializable {
    
    @DynamoDBHashKey(attributeName = "professorId")
    @DynamoDBAutoGeneratedKey
    private String professorId;
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private String emailId;
    @DynamoDBAttribute
    private String skills;
    @DynamoDBAttribute
    private String primarySkill;
    @DynamoDBAttribute
    private int workingExperience;
    @DynamoDBAttribute
    private Address address;
}
