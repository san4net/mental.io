package com.mental.io.data;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Session {
    private long id;
    private Status status;
    private int sessionCount;
    private Date startTime;
    private int durationInMinute;
    private List<Audios> videos;

}
