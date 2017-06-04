package com.example.itqan.taskimages;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.itqan.taskimages.adapter.RecyclerAdapterAlbums;
import com.example.itqan.taskimages.model.ImagesModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity   {

    RecyclerView recyclerView;
    RecyclerAdapterAlbums recyclerAdapterAlbums;
    List<ImagesModel>imagesModelArrayList =  new ArrayList<>();
  public   static String urlimages[] = {
            "https://cdn.pixabay.com/photo/2012/05/29/00/43/car-49278_960_720.jpg",
            "http://st.motortrend.com/uploads/sites/10/2016/04/2016-Mazda-MX-5-front-three-quarter-02-2.jpg",
            "http://media.caranddriver.com/images/media/638444/porsche-boxster-photo-640543-s-original.jpg",
            "http://s013.radikal.ru/i323/1208/c9/50e2df3e15e9.jpg",
            "https://527f3da9b2fc6dc2f392-25e68eb43821fd10fd94298a9086cec7.ssl.cf1.rackcdn.com/WP0AD2A91FS166767/e8a87ec7f05c9b57923b51c4a6dfdcdd.jpg"
    };
   public static  int idimages[] = {
            1,
            2,
            3,
            4,
            5
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()){
            recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
            recyclerView.setHasFixedSize(true);
                recyclerAdapterAlbums = new RecyclerAdapterAlbums(getApplicationContext(),getImagesModelsalbum());

            recyclerView.setAdapter(recyclerAdapterAlbums);

        }else{
            Toast.makeText(getApplicationContext(),"Not Connection",Toast.LENGTH_SHORT).show();

        }


    }

    private List<ImagesModel>getImagesModelsalbum(){

        for(int i =0;i<idimages.length;i++){
            ImagesModel imagesModel = new ImagesModel(urlimages[i],idimages[i]);

            imagesModelArrayList.add(imagesModel);
//            if(imagesModel.getAlbumid()==idalbum){
//                Toast.makeText(getApplicationContext(),"found album" + idimages[i],Toast.LENGTH_LONG).show();
//            }else{
//                Toast.makeText(getApplicationContext(),"not found album",Toast.LENGTH_LONG).show();
//            }
        }
        return  imagesModelArrayList;
    }



}
