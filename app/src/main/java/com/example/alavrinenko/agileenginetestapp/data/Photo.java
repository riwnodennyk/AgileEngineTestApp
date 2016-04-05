package com.example.alavrinenko.agileenginetestapp.data;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;

@AutoValue
public abstract class Photo {

    @Json(name = "id")
    public abstract String id();

    @Json(name = "name")
    public abstract String name();

    @Json(name = "description")
    @Nullable
    public abstract String description();

    public static AutoValue_Photo.AutoValue_PhotoJsonAdapterFactory typeAdapterFactory() {
        return AutoValue_Photo.typeAdapterFactory();
    }
}
