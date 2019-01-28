package com.dinamicarea.ejemplorecyclerview.data.api.mapper;

import com.dinamicarea.ejemplorecyclerview.data.dto.MovieDTO;
import com.dinamicarea.ejemplorecyclerview.data.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {
    //convierte objetos de la api en objetos de nuestra aplication

    public static List<Movie> entityListFrom(List<MovieDTO> dtoList) {
        List<Movie> entities = new ArrayList<>();

        for (MovieDTO dto : dtoList) {
            entities.add(entityFrom(dto));

        }
        return entities;
    }

    public static Movie entityFrom(MovieDTO dto) {
        Movie entity = new Movie();
        entity.setTitle(dto.getTitle());
        entity.setCoverUrl(dto.getPoster_path());
        entity.setYear(dto.getRelease_date());

        return entity;
    }
}
