BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO genre (genre_name)
VALUES ('Classic Rock')

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('One Of These Nights', 'Eagles', 1);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Stairway To Heaven', 'Led Zeppelin', 1);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Free Bird', 'Lynyrd Skynyrd', 1);

INSERT INTO genre (genre_name)
VALUES ('Hip-Hop / Rap')

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Too Many Nights', 'Metro Boomin', 2);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Spin Bout U', 'Drake', 2);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('She Will', 'Lil Wayne', 2);

INSERT INTO genre (genre_name)
VALUES ('R&B')

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Your Love Is King', 'Sade', 3);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Wicked Games', 'The Weeknd', 3);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Nobody', 'Keith Sweat', 3);

INSERT INTO genre (genre_name)
VALUES ('Alternative')

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Tongue Tied', 'Grouplove', 4);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Safe and Sound', 'Capital Cities', 4);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Doses & Mimosas', 'Cherub', 4);

INSERT INTO genre (genre_name)
VALUES ('Pop')

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('What''s My Name', 'Rihanna', 5);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('One Kiss', 'Calvin Harris', 5);

INSERT INTO song (song_name, artist_name, genre_id)
VALUES ('Just Can''t Get Enough', 'Black Eyed Peas', 5);

INSERT INTO playlist (dj_id, playlist_name)
VALUES (3001, 'The Classics');

INSERT INTO playlist_song (playlist_id, song_id)
VALUES (1, 1);

INSERT INTO playlist_song (playlist_id, song_id)
VALUES (1, 2);

INSERT INTO playlist_song (playlist_id, song_id)
VALUES (1, 3);

INSERT INTO host_playlist (host_id, playlist_id)
VALUES (2001, 1);

COMMIT TRANSACTION;
