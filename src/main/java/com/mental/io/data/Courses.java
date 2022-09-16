package com.mental.io.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
//@NoArgsConstructor
@AllArgsConstructor
@Builder
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Courses {
    @Id
    @JsonProperty
    private long courseId;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @JsonProperty
    private CoursesJson coursesJson;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedAt;

    public Courses() {
        this.createdAt= Calendar.getInstance().getTime();
    }
}
