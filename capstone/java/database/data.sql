BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO playlist (playlist_uri, dj_id, playlist_name)
VALUES ('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 3001, 'Graduation Playlist');

INSERT INTO playlist (playlist_uri, dj_id, playlist_name)
VALUES ('spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 3001, 'Bottle & Cork NYE Playlist');

INSERT INTO genre (genre_name)
VALUES('Hip/Hop');

INSERT INTO genre (genre_name)
VALUES('Classic Rock');

INSERT INTO song (track_uri, song_name, artist_name, genre_id)
VALUES ('spotify:track:2ZL7WZcjuYKi1KUDtp4kCC', 'Spin Bout U', 'Drake', 1),
('spotify:track:51pshtuYkgUQnt5huMPbKL', 'The Spins', 'Mac Miller', 1),
('spotify:track:4wqzOaLxiCRy2Et8tRyNSX', 'The Thrill', 'Wiz Khalifa', 1),
('spotify:track:6MXXY2eiWkpDCezVCc0cMH', 'Good Morning', 'Kanye West', 1),
('spotify:track:5bJ1DrEM4hNCafcDd1oxHx', 'Self Care', 'Mac Miller', 1);

INSERT INTO song (track_uri, song_name, artist_name, genre_id)
VALUES ('spotify:track:5VSAonaAPhhGn0G7hMYwWK', 'Sister Golden Hair', 'America', 2),
('spotify:track:0P7DoyGrr4Wp9w5TotEtUC', 'The Weight', 'The Band', 2),
('spotify:track:4BP3uh0hFLFRb5cjsgLqDh', 'Fortunate Son', 'Creedence Clearwater Revival', 2),
('spotify:track:608xszaAxVh4m7NcKJiAbF', 'One of These Nights', 'Eagles', 2),
('spotify:track:5CQ30WqJwcep0pYcV4AMNc', 'Stairway To Heaven', 'Led Zeppelin', 2);

INSERT INTO playlist_song (playlist_uri, track_uri)
VALUES ('spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 'spotify:track:5VSAonaAPhhGn0G7hMYwWK'),
('spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 'spotify:track:0P7DoyGrr4Wp9w5TotEtUC'),
('spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 'spotify:track:4BP3uh0hFLFRb5cjsgLqDh'),
('spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 'spotify:track:608xszaAxVh4m7NcKJiAbF'),
('spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 'spotify:track:5CQ30WqJwcep0pYcV4AMNc');


INSERT INTO playlist_song (playlist_uri, track_uri)
VALUES ('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:2ZL7WZcjuYKi1KUDtp4kCC'),
('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:51pshtuYkgUQnt5huMPbKL'),
('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:4wqzOaLxiCRy2Et8tRyNSX'),
('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:6MXXY2eiWkpDCezVCc0cMH'),
('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:5bJ1DrEM4hNCafcDd1oxHx');



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
