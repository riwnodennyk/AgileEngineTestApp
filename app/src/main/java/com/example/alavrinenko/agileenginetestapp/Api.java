package com.example.alavrinenko.agileenginetestapp;

import com.example.alavrinenko.agileenginetestapp.data.Page;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {
    @GET("photos?feature=popular&consumer_key=wB4ozJxTijCwNuggJvPGtBGCRqaZVcF6jsrzUadF")
    Observable<Page> page(@Query("page") int page);
}
