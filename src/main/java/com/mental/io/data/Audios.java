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
public class Audios {

    @Id
    @GeneratedValue
    private long audioId;
    private String audioPath;
    private String question;
    private String answer;
    private String userAnswer;
    private String response;
    private String correct; // yes or no
    private AudioType audioType;
    private AudioCategory audioCategory;
    private Date createdAt;
    private Date updatedAt;


}
