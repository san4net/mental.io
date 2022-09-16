package com.mental.io.data;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class CoursesJson {
    private long courseId;
    private Status status;
    private int sessionCount;
    private List<Session> sessions;


}
