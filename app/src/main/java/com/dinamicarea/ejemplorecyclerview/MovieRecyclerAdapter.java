package com.dinamicarea.ejemplorecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dinamicarea.ejemplorecyclerview.data.api.RestClient;
import com.dinamicarea.ejemplorecyclerview.data.entity.Movie;

import java.util.ArrayList;


public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder> {

    Context context;
    int resource;
    ArrayList<Movie> movies;


    public MovieRecyclerAdapter(Context context, int resource, ArrayList<Movie> movies) {
        this.context = context;
        this.resource = resource;
        this.movies = movies;
    }

    /**
     * Se encarga de crear la vista de la celda a partir de la celda en xml
     *
     * @param viewGroup "padre" de nuestra vista
     * @param i         posición de la celda en la lista
     * @return viewholder creado.
     */
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Paso 1: "Inflamos" la celda. Que nos llega en resource
        View itemView = LayoutInflater.from(context).
                inflate(resource, viewGroup, false);

        //Paso 2: Crear el viewholder
        MovieViewHolder movieViewHolder = new MovieViewHolder(itemView, context);

        //Paso 3: Lo devolvemos
        return movieViewHolder;
    }


    /**
     * Se encarga de rellenar un viewholder recibido como parámetro con
     * la película correspondiente
     *
     * @param movieViewHolder viewholder con la celda que hay que rellenar
     * @param position        posición que ocupa esa celda en el listado
     */
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int position) {
        //Saco la película en la posición correspondiente
        Movie movie = movies.get(position);

        //Relleno el viewholder con la película
        movieViewHolder.bindMovie(movie);

    }

    /**
     * Devuelve el número de elementos de la lista
     *
     * @return número de elementos de la lista
     */
    @Override
    public int getItemCount() {
        return movies.size();
    }

    /**
     * Clase interna al adapter que representa a un viewholder
     */
    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ImageView ivCover;
        TextView tvTitle;
        TextView tvGenreAndYear;

        public MovieViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            this.context = context;
            ivCover = itemView.findViewById(R.id.ivCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvGenreAndYear = itemView.findViewById(R.id.tvGenreAndYear);
        }

        /**
         * Enlaza la película con el viewHolder
         *
         * @param movie película
         */
        public void bindMovie(Movie movie) {
            tvTitle.setText(movie.getTitle());
            String genreAndText = movie.getGenre() + " / " + movie.getYear();
            tvGenreAndYear.setText(genreAndText);
            String url = RestClient.imageBaseUrl + movie.getCoverUrl();
            Glide.with(context).load(url).into(ivCover);
        }


    }
}
