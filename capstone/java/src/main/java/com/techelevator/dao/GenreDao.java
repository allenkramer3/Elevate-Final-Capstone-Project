package com.techelevator.dao;

import com.techelevator.controller.model.Genre;

public interface GenreDao {

    void createGenre (Genre genre);

    void deleteGenre (Genre genre);
}
