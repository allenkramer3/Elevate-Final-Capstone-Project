BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dj;
DROP TABLE IF EXISTS playlist;
DROP TABLE IF EXISTS host;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS playlist_song;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE dj (
    dj_id SERIAL,
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

CREATE TABLE host (
    host_id SERIAL,
    user_id int NOT NULL,
    playlist_id int NOT NULL,
    CONSTRAINT PK_host PRIMARY KEY (host_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_playlist_id FOREIGN KEY (playlist_id) REFERENCES playlist (playlist_id)
);

CREATE TABLE event (
    event_id SERIAL,
    host_id int NOT NULL,
    dj_id int NOT NULL,
    event_name varchar(200) NOT NULL UNIQUE,
    event_information varchar(1000) NOT NULL,
    genres varchar(100) NOT NULL,
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

COMMIT TRANSACTION;
