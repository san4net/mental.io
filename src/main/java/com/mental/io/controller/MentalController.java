package com.mental.io.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mental.io.data.*;
import com.mental.io.request.AddVideoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class MentalController {
    private static final Logger log = LoggerFactory.getLogger(MentalController.class);

    private JpaRepository<User, Long> userRepository ;
    private JpaRepository<Courses,Long> coursesJpaRepository;
    private JpaRepository<Audios,Long> audioRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public MentalController(JpaRepository<User, Long> userRepository, JpaRepository<Courses, Long> coursesJpaRepository, JpaRepository<Audios, Long> videoRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.coursesJpaRepository = coursesJpaRepository;
        this.audioRepository = videoRepository;
        this.objectMapper = objectMapper;
    }



    @GetMapping("/health")
    public String health(){
        return "up";
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<?> login(@RequestBody User user){
        String username = user.getUserName();
        String password = user.getPassword();

        if(Objects.nonNull(username) && Objects.nonNull(password) && !username.isEmpty() && !password.isEmpty()) {

            if(username.equals(password)) {

                return new ResponseEntity<>(username, HttpStatus.OK);

            } else {

                return new ResponseEntity<>("Username and Password not matched incorrect", HttpStatus.BAD_REQUEST);

            }

        }

        else {

            return new ResponseEntity<>("Username or password is incorrect", HttpStatus.BAD_REQUEST);

        }

    }


    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id){
        return userRepository.findById(id).get();
    }


    @PostMapping(
            value = "/create/course",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Courses createCourse(@RequestBody Courses request){
         return coursesJpaRepository.saveAndFlush(request);
    }

    @GetMapping("/course/{id}")
    public List<Courses> getCourse(@PathVariable long id){
        return coursesJpaRepository.findById(id).stream().toList();
    }
    @GetMapping("/course")
    public List<Courses> getCourse(){
        return coursesJpaRepository.findAll();
    }

    @GetMapping("/save/video")
    public Audios addVideo(@RequestBody  AddVideoRequest request){
        return audioRepository.save(Audios.builder().audioPath(request.getVideoPath()).question(request.getQuestion()).build());
    }


    private Courses generatedCourse(DummyRequest request){
        return Courses.builder().createdAt(Calendar.getInstance().getTime())
                .coursesJson(CoursesJson.builder()
                         .sessionCount(12)
                        .sessions(List.of(Session.builder().id(1)
                                .status(Status.DUE)
                                .startTime(Calendar.getInstance().getTime())
                                .durationInMinute(5)
                                .videos(videos(12))
                                .build()))
                        .build()).build();

    }

    private List<Audios> videos(int count) {
      Random r =  new Random();
      List<Audios> lists = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lists.add(Audios.builder()
                    .audioPath("/path1/vk1.mp3"+r.nextInt())
                    .audioCategory(AudioCategory.SOCIAL)
                    .audioType(AudioType.VIVID)
                    .question("Do you remember last video we played")
                    .createdAt(Calendar.getInstance().getTime())
                    .build());
        }
        return lists;
    }
}
