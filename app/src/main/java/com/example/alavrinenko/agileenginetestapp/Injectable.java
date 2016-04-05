package com.example.alavrinenko.agileenginetestapp;

import android.support.annotation.NonNull;

import com.example.alavrinenko.agileenginetestapp.data.Page;
import com.example.alavrinenko.agileenginetestapp.data.Photo;
import com.example.alavrinenko.agileenginetestapp.data.User;
import com.squareup.moshi.Moshi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Injectable {
    public static Api api() {
        return api(retrofit());
    }

    private static Api api(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @NonNull
    private static Retrofit retrofit() {
        return retrofit(moshi());
    }

    @NonNull
    private static Retrofit retrofit(Moshi moshi) {
        return new Retrofit.Builder()
                .baseUrl("https://api.500px.com/v1/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();
    }

    private static Moshi moshi() {
        return new Moshi.Builder()
                .add(Page.typeAdapterFactory())
                .add(Photo.typeAdapterFactory())
                .add(User.typeAdapterFactory())
                .build();
    }
}
