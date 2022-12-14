CREATE TABLE IF NOT EXISTS USERS(
    USER_ID bigserial PRIMARY KEY,
    USER_NAME VARCHAR ,
    PASSWORD VARCHAR
);

CREATE TABLE IF NOT EXISTS VIDEOS(
    VIDEO_ID BIGSERIAL PRIMARY KEY ,
    VIDEO_PATH VARCHAR,
    CREATED_AT timestamptz   DEFAULT (now()) ,
    UPDATED_AT timestamptz
);

CREATE TABLE IF NOT EXISTS COURSES(
    COURSE_ID INT8 PRIMARY KEY,
    COURSE_JSON JSON,
    CREATED_AT timestamptz  DEFAULT (now()) ,
    UPDATED_AT timestamptz
);


-- CREATE TABLE IF NOT EXISTS ENROLMENT(
--     ENROLMENT_ID BIGSERIAL PRIMARY KEY,
--     USER_ID int8 ,
--     COURSE_ID int8,
--     COURSE_JSON JSON,
--     CREATED_AT timestamptz   DEFAULT (now()) ,
--     UPDATED_AT timestamptz,
--     STATUS varchar
--     CONSTRAINT fk_user_id FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID) ON DELETE CASCADE,
--     CONSTRAINT fk_course_id FOREIGN KEY (COURSE_ID) REFERENCES COURSES(COURSE_ID) ON DELETE CASCADE
-- );
