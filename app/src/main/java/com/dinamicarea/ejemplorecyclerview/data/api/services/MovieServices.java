package com.dinamicarea.ejemplorecyclerview.data.api.services;

import com.dinamicarea.ejemplorecyclerview.data.dto.ListOfMoviesDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieServices {

    //https://api.themoviedb.org/3/movie/upcoming?api_key=2cb88f6bdd09877db8127bcd6208914a&language=en-US&page=1


    @GET("movie/upcoming")
    Call<ListOfMoviesDTO> getUpcomingMovies(
            @Query("api_key") String apiKey,
            @Query("Language") String Language,
            @Query("page") Integer page);


}
