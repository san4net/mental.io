package com.mental.io.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    private long questionId;
    private String question;
    private String answer;
    private QuestionType questionType;
    private QuestionCategory questionCategory;
    private Date createdAt;
    private Date updatedAt;
    private String scenarioText;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;


}
