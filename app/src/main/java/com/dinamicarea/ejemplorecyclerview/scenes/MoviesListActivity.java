package com.dinamicarea.ejemplorecyclerview.scenes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dinamicarea.ejemplorecyclerview.MovieRecyclerAdapter;
import com.dinamicarea.ejemplorecyclerview.R;
import com.dinamicarea.ejemplorecyclerview.data.BusinessCallback;
import com.dinamicarea.ejemplorecyclerview.data.entity.Movie;
import com.dinamicarea.ejemplorecyclerview.scenes.movielist.MoviesListManager;

import java.util.ArrayList;
import java.util.List;

public class MoviesListActivity extends AppCompatActivity {


    RecyclerView rvMovies;
    ArrayList<Movie> movies = new ArrayList<>();
    MovieRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movieslist);

        initview();
        loadData();

    }

    private void loadData() {
        MoviesListManager.getMovieList(1, new BusinessCallback<List<Movie>>() {
            @Override
            public void success(List<Movie> moviesFromManager) {
                movies.addAll(moviesFromManager);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void failure(Object error) {
                Toast.makeText(
                        MoviesListActivity.this,
                        "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initview() {
        //Enlazamos el xml con la variable java.
        rvMovies = findViewById(R.id.rvMovies);

        //Añadimos las películas
        //addMovies();

        //Creamos el adapter
        adapter =
                new MovieRecyclerAdapter(
                        this,
                        R.layout.cardview_movie,
                        movies);

        //El layout manager le dice al RV cómo se tiene que pintar
        //De forma lineal
//        LinearLayoutManager manager =
//                new LinearLayoutManager(
//                        this,
//                        LinearLayoutManager.VERTICAL,
//                        false);

        GridLayoutManager manager = new GridLayoutManager(this, 2);

        rvMovies.setLayoutManager(manager);
        rvMovies.setAdapter(adapter);
    }

    private void addMovies() {
        for (int index = 0; index < 100; index++) {
            Movie movie = new Movie();
            movie.setCoverUrl("https://image.tmdb.org/t/p/w600_and_h900_bestv2/z5gqW3fffzQ16Jv5vDScpypq1FA.jpg");
            String title = "Película número " + index;
            movie.setTitle(title);
            movie.setGenre("Género");
            movie.setYear("2019");

            movies.add(movie);
        }
    }
}
