package com.example.itqan.taskimages.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itqan.taskimages.DetailsActivity;
import com.example.itqan.taskimages.R;
import com.example.itqan.taskimages.model.ImagesModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapterAlbums extends RecyclerView.Adapter<RecyclerAdapterAlbums.ViewHolderAlbum> {

   private List<ImagesModel>imagesModels = new ArrayList<>();
   private  Context context;


    public  RecyclerAdapterAlbums(Context context , List<ImagesModel>imagesModels){
        this.context=context;
        this.imagesModels=imagesModels;
    }
    @Override
    public ViewHolderAlbum onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_album,null);

        return new ViewHolderAlbum(view,context,imagesModels);
    }

    @Override
    public void onBindViewHolder(ViewHolderAlbum holder, int position) {

        ImagesModel imagesModel = imagesModels.get(position);
        holder.txttitlealbumid.setText(""+imagesModel.getAlbumid());

        Uri uri = Uri.parse(imagesModel.getUrl());
        Picasso.with(context)
                .load(uri)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imagesModels.size();
    }

    static class ViewHolderAlbum extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txttitlealbumid;
        CardView cardview;
        Context context;
        public ViewHolderAlbum(View itemView, final Context context , final List<ImagesModel> imagesModelList) {
            super(itemView);
            this.context=context;
            imageView=(ImageView)itemView.findViewById(R.id.image);
            txttitlealbumid=(TextView)itemView.findViewById(R.id.txttitleid);
            cardview=(CardView)itemView.findViewById(R.id.cardview);

            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    ImagesModel imagesModel = imagesModelList.get(position);
                    Intent intent = new Intent(context.getApplicationContext(),DetailsActivity.class);
                    intent.putExtra("albumimageid",imagesModel.getAlbumid());
                    intent.putExtra("albumimagename",imagesModel.getAlbumname());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            });

        }
    }
}
