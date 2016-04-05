package com.example.alavrinenko.agileenginetestapp.data;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;

@AutoValue
public abstract class Photo implements Parcelable {

    public static AutoValue_Photo.AutoValue_PhotoJsonAdapterFactory typeAdapterFactory() {
        return AutoValue_Photo.typeAdapterFactory();
    }

    @Json(name = "id")
    public abstract String id();

    @Json(name = "name")
    public abstract String name();

    @Json(name = "description")
    @Nullable
    public abstract String description();

    @Json(name = "camera")
    @Nullable
    public abstract String camera();

    @Json(name = "user")
    @Nullable
    public abstract User user();

    @Json(name = "image_url")
    public abstract String imageUrl();
}
