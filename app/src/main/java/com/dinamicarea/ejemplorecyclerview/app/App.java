package com.dinamicarea.ejemplorecyclerview.app;

import android.app.Application;

import com.dinamicarea.ejemplorecyclerview.data.api.RestClient;

public class App extends Application {
    static App instance;
    RestClient restClient;

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public RestClient getRestClient() {

        if (restClient == null) {
            restClient = new RestClient();
        }
        return restClient;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }
}
