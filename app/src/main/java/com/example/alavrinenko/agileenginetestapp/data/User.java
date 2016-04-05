package com.example.alavrinenko.agileenginetestapp.data;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;

@AutoValue
public abstract class User implements Parcelable {

    public static AutoValue_User.AutoValue_UserJsonAdapterFactory typeAdapterFactory() {
        return AutoValue_User.typeAdapterFactory();
    }

    @Json(name = "username")
    public abstract String username();

}
