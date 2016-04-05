package com.example.alavrinenko.agileenginetestapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alavrinenko.agileenginetestapp.data.Photo;
import com.squareup.picasso.Picasso;

/**
 * A fragment representing a single Photo detail screen.
 * This fragment is either contained in a {@link PhotoListActivity}
 * in two-pane mode (on tablets) or a {@link PhotoDetailActivity}
 * on handsets.
 */
public class PhotoDetailFragment extends Fragment {

    public static final String ARG_PHOTO = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Photo photo;

    public PhotoDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_PHOTO)) {
            photo = getArguments().getParcelable(ARG_PHOTO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.photo_detail, container, false);

        if (photo != null) {
            String cameraName = photo.camera();
            String details = photo.user().username();
            if (!TextUtils.isEmpty(cameraName)) {
                details += "\n" + cameraName;
            }
            ((TextView) rootView.findViewById(R.id.photo_detail)).setText(details);
            ImageView viewById = (ImageView) rootView.findViewById(R.id.full_image);
            Picasso.with(getContext())
                    .load(photo.imageUrl())
                    .into(viewById);
        }

        return rootView;
    }
}
