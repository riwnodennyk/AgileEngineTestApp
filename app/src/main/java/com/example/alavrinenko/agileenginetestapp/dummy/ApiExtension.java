package com.example.alavrinenko.agileenginetestapp.dummy;

import com.example.alavrinenko.agileenginetestapp.Injectable;
import com.example.alavrinenko.agileenginetestapp.data.Page;
import com.example.alavrinenko.agileenginetestapp.data.Photo;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiExtension {

    public static Observable<Photo> withId(String photoId) {
        return photos()
                .filter(photo -> photo.id().equals(photoId))
                .first();
    }

    public static Observable<Photo> photos() {
        return firstPage()
                .flatMapIterable(Page::photos);
    }

    private static Observable<Page> firstPage() {
        return Injectable.api()
                .page(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
