BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS dj CASCADE;
DROP TABLE IF EXISTS playlist CASCADE;
DROP TABLE IF EXISTS host CASCADE;
DROP TABLE IF EXISTS event CASCADE;
DROP TABLE IF EXISTS genre CASCADE;
DROP TABLE IF EXISTS song CASCADE;
DROP TABLE IF EXISTS playlist_song CASCADE;
DROP TABLE IF EXISTS host_playlist CASCADE;

DROP SEQUENCE IF EXISTS seq_user_id, seq_dj_id, seq_host_id;

CREATE SEQUENCE seq_user_id
    INCREMENT BY 1
    START WITH 1001
    NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_dj_id
    INCREMENT BY 1
    START WITH 3001
    NO MAXVALUE;

CREATE TABLE dj (
    dj_id int NOT NULL DEFAULT nextval('seq_dj_id'),
    user_id int NOT NULL,
    CONSTRAINT PK_dj PRIMARY KEY (dj_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE playlist (
    playlist_id SERIAL,
    dj_id int NOT NULL,
    playlist_name varchar(50),
    CONSTRAINT PK_playlist PRIMARY KEY (playlist_id),
    CONSTRAINT FK_dj_id FOREIGN KEY (dj_id) REFERENCES dj (dj_id)
);

CREATE SEQUENCE seq_host_id
    INCREMENT BY 1
    START WITH 2001
    NO MAXVALUE;

CREATE TABLE host (
    host_id int NOT NULL DEFAULT nextval('seq_host_id'),
    user_id int NOT NULL,
    CONSTRAINT PK_host PRIMARY KEY (host_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE event (
    event_id SERIAL,
    host_id int NOT NULL,
    dj_id int NOT NULL,
    event_name varchar(200),
    event_information varchar(1000),
    genres varchar(100),
    event_picture varchar(100),
    CONSTRAINT PK_event PRIMARY KEY (event_id),
    CONSTRAINT FK_host_id FOREIGN KEY (host_id) REFERENCES host (host_id),
    CONSTRAINT FK_dj_id FOREIGN KEY (dj_id) REFERENCES dj (dj_id)
);

CREATE TABLE genre (
    genre_id SERIAL,
    genre_name varchar(50) NOT NULL UNIQUE,
    CONSTRAINT PK_genre PRIMARY KEY (genre_id)
);

CREATE TABLE song (
    song_id SERIAL,
    song_name varchar(100) NOT NULL,
    artist_name varchar(50) NOT NULL,
    genre_id int NOT NULL,
    CONSTRAINT PK_song PRIMARY KEY (song_id),
    CONSTRAINT FK_genre_id FOREIGN KEY (genre_id) REFERENCES genre (genre_id)
);

CREATE TABLE playlist_song (
    playlist_id int NOT NULL UNIQUE,
    song_id int NOT NULL UNIQUE,
    CONSTRAINT FK_playlist_id FOREIGN KEY (playlist_id) REFERENCES playlist (playlist_id),
    CONSTRAINT FK_song_id FOREIGN KEY (song_id) REFERENCES song (song_id)
);

CREATE TABLE host_playlist (
    host_id int NOT NULL,
    playlist_id int NOT NULL,
    CONSTRAINT FK_host_id FOREIGN KEY (host_id) REFERENCES host (host_id),
    CONSTRAINT FK_playlist_id FOREIGN KEY (playlist_id) REFERENCES playlist (playlist_id)
);

DROP USER IF EXISTS final_capstone_owner;
DROP USER IF EXISTS final_capstone_appuser;

CREATE USER final_capstone_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

CREATE USER final_capstone_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;

COMMIT TRANSACTION;

ROLLBACK;



