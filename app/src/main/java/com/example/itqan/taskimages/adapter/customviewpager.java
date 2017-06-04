package com.example.itqan.taskimages.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class customviewpager extends PagerAdapter {

    Activity activity;
    List<ImagesModel> imagesModels = new ArrayList<>();

    boolean check = true;
    int c = 0 ;
    public customviewpager(Activity activity, List<ImagesModel> imagesModels) {
        this.activity = activity;
        this.imagesModels = imagesModels;
    }
    @Override
    public int getCount() {
        return imagesModels.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view==(LinearLayout)object);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        LayoutInflater layoutInflater =(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.list_items_images,container,false);

        ImageView imageView = (ImageView)view.findViewById(R.id.detailsimage);
        Intent extra = activity.getIntent();

        if (extra != null) {

            int albumid = extra.getIntExtra("albumimageid", -1);
            Toast.makeText(activity, "Not Null", Toast.LENGTH_SHORT).show();





                    Picasso.with(activity)
                            .load(MainActivity.urlimages[albumid-1])
                            .into(imageView);


            Toast.makeText(activity.getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();


                for (albumid= 0 ;albumid<position;albumid++) {

                    if(check)

                        check=false;

                        Picasso.with(activity)
                                .load(MainActivity.urlimages[position])
                                .into(imageView);


            }

        } else {
            Toast.makeText(activity, "Null", Toast.LENGTH_SHORT).show();
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
