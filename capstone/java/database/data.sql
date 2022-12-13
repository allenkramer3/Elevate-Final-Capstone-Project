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

INSERT INTO playlist_song (playlist_uri, track_uri)
VALUES ('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:2ZL7WZcjuYKi1KUDtp4kCC'),
('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:51pshtuYkgUQnt5huMPbKL'),
('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:4wqzOaLxiCRy2Et8tRyNSX'),
('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:6MXXY2eiWkpDCezVCc0cMH'),
('spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'spotify:track:5bJ1DrEM4hNCafcDd1oxHx');

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

INSERT INTO event (host_id, dj_id, playlist_uri, event_name, event_information, genres, event_picture)
VALUES (2001, 3001, 'spotify:playlist:5o0ZidwaV7XrPJ4j43uqNu', 'Graduation', 'Friday December 16th 4:30pm-6:30pm - Come celebrate the hard accomplishments of WILM Java Cohort 2!', 'Lit', '');

INSERT INTO event (host_id, dj_id, playlist_uri, event_name, event_information, genres, event_picture)
VALUES (2001, 3001, 'spotify:playlist:17cjDMmgMoUIrTomJc0tmc', 'Bottle & Cork New Year''s Day Jam', 'January 2nd 4:00pm-7:30pm - Come ring in the New Year with live acts and cold beverages!', 'Classic Rock', '');

COMMIT TRANSACTION;