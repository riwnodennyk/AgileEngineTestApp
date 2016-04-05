package com.example.alavrinenko.agileenginetestapp.dummy;

import com.example.alavrinenko.agileenginetestapp.Injectable;
import com.example.alavrinenko.agileenginetestapp.data.Page;
import com.example.alavrinenko.agileenginetestapp.data.Photo;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    public static Observable<Photo> withId(String itemId) {
        return photos()
                .filter(photo -> photo.id().equals(itemId))
                .first();
    }

    public static Observable<Photo> photos() {
        return items().flatMapIterable(Page::photos);
    }

    private static Observable<Page> items() {
        return Injectable.api().listRepos(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                ;
    }

}
