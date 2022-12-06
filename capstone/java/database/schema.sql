BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS event_host;
DROP TABLE IF EXISTS dj;
DROP TABLE IF EXISTS playlist;
DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS genre;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE event (
    event_id SERIAL,
    dj_id int NOT NULL,
    event_name varchar(200) NOT NULL UNIQUE,
    event_information varchar(1000) NOT NULL,
    genre_id int NOT NULL,
    event_picture varchar(100)
);

CREATE TABLE event_host (
    host_id SERIAL,
    event_id int NOT NULL,
    user_id int NOT NULL,
    playlist_id int NOT NULL
);

CREATE TABLE dj (
    dj_id SERIAL,
    user_id int NOT NULL
);

CREATE TABLE playlist (
    playlist_id SERIAL,
    genre_id int NOT NULL,
    dj_id int NOT NULL
);

CREATE TABLE song (
    song_id SERIAL,
    song_name varchar(100) NOT NULL,
    artist_id int NOT NULL,
    genre_id int NOT NULL
);

CREATE TABLE artist (
    artist_id SERIAL,
    artist_name varchar(50) NOT NULL
);

CREATE TABLE genre (
    genre_id SERIAL,
    genre_name varchar(50) NOT NULL UNIQUE
);

COMMIT TRANSACTION;
