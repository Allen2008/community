CREATE TABLE question
(
    id int PRIMARY KEY,
    title varchar(50),
    description text,
    gmt_create bigint,
    creator int,
    comment_count int DEFAULT 0,
    view_count int DEFAULT 0,
    like_count int DEFAULT 0,
    tag varchar(256)
);