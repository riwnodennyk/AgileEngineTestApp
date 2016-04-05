package com.example.alavrinenko.agileenginetestapp.data;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;

import java.util.List;

@AutoValue
public abstract class Page implements Parcelable {
    @Json(name = "current_page")
    abstract int currentPage();

    @Json(name = "total_pages")
    abstract int totalPages();

    @Json(name = "total_items")
    abstract int totalItems();

    @Json(name = "photos")
    public abstract List<Photo> photos();

    public static JsonAdapter.Factory typeAdapterFactory() {
        return AutoValue_Page.typeAdapterFactory();
    }
}
