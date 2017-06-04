package com.example.itqan.taskimages;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.itqan.taskimages.adapter.HorzontalRecyclerDetailsImages;
import com.example.itqan.taskimages.adapter.customviewpager;
import com.example.itqan.taskimages.model.ImagesModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    //  ImageView imageView;



    boolean found;
    int counter = 0;
    // RecyclerView recyclerView;
    HorzontalRecyclerDetailsImages horzontalRecyclerDetailsImages;

    ViewPager viewPager;

    customviewpager customviewpagers;
    List<ImagesModel> imagesModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //  imageView=(ImageView)findViewById(R.id.detailsimage);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        customviewpagers = new customviewpager(DetailsActivity.this, retriveallimages());
        viewPager.setAdapter(customviewpagers);

        // recyclerView=(RecyclerView)findViewById(R.id.imagesrecyclerview);

//        Intent extra =  getIntent();
//
//        if(extra!=null) {
//
//            int albumid = extra.getIntExtra("albumimageid",-1);
//            Toast.makeText(getApplicationContext(),"Not Null",Toast.LENGTH_SHORT).show();
//
//
//
//            if(albumid!=-1) {
//                Picasso.with(getApplicationContext())
//                        .load(MainActivity.urlimages[albumid-1])
//                        .into(imageView);
//
//
//            }
//            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
//            recyclerView.setHasFixedSize(true);
//            horzontalRecyclerDetailsImages=new HorzontalRecyclerDetailsImages(DetailsActivity.this,retriveallimages());
//            recyclerView.setAdapter(horzontalRecyclerDetailsImages);


//        }else{
//            Toast.makeText(getApplicationContext(),"Null",Toast.LENGTH_SHORT).show();
//        }


    }

    private List<ImagesModel> retriveallimages() {


        ImagesModel imagesModela = new ImagesModel();


        ImagesModel imagesModel = new ImagesModel(MainActivity.urlimages[imagesModela.getAlbumid()]);

        imagesModels.add(imagesModel);
//
//        for (int i = 0; i < MainActivity.urlimages.length - 1; i++) {
//
//
////
////            if(!urlimages[i].equals(imagesModel.getAlbumid())){
////
////                found=false;
////
////            }else{
//
//           // }
//
//

//        }


        for(int j =0;j<MainActivity.urlimages.length-1;j++){

            ImagesModel anotherimagesModel = new ImagesModel(MainActivity.urlimages[j]);




                imagesModels.add(anotherimagesModel);
            }




        return imagesModels;
            }
        }




