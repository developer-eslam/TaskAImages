package com.example.itqan.taskimages.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.itqan.taskimages.MainActivity;
import com.example.itqan.taskimages.R;
import com.example.itqan.taskimages.model.ImagesModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eslam on 6/3/2017.
 */

public class HorzontalRecyclerDetailsImages extends RecyclerView.Adapter<HorzontalRecyclerDetailsImages.ViewHolderImages> {


    Activity activity;
    List<ImagesModel> imagesModels = new ArrayList<>();

    public HorzontalRecyclerDetailsImages(Activity activity, List<ImagesModel> imagesModels) {
        this.activity = activity;
        this.imagesModels = imagesModels;
    }

    @Override
    public ViewHolderImages onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_images, null);

        return new ViewHolderImages(view,activity);
    }

    @Override
    public void onBindViewHolder(ViewHolderImages holder, int position) {

        ImagesModel imagesModel = imagesModels.get(position);
        Uri uri = Uri.parse(imagesModel.getUrl());
        Picasso.with(activity.getApplicationContext())
                .load(uri)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imagesModels.size();
    }

   public static class ViewHolderImages extends RecyclerView.ViewHolder {
       ImageView imageView;
        Activity activity;

        public ViewHolderImages(View itemView, Activity activity) {
            super(itemView);
            this.activity = activity;

            imageView = (ImageView) itemView.findViewById(R.id.detailsimage);

            Intent extra = activity.getIntent();

            if (extra != null) {

                int albumid = extra.getIntExtra("albumimageid", -1);
                Toast.makeText(activity, "Not Null", Toast.LENGTH_SHORT).show();


                if (albumid != -1) {
                    Picasso.with(activity)
                            .load(MainActivity.urlimages[albumid - 1])
                            .into(imageView);
                }

            } else {
                Toast.makeText(activity, "Null", Toast.LENGTH_SHORT).show();
            }
        }


    }
}

