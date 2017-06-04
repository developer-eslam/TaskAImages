package com.example.itqan.taskimages.model;

import java.io.Serializable;


public class ImagesModel  implements Serializable{

    private String url;
    private String title;
    private String albumname;
    private int albumid;

    public ImagesModel(){
    }
    public ImagesModel(int id){
        setAlbumid(id);
    }

    public ImagesModel(String url){
        setUrl(url);
    }
    public ImagesModel(String url,int albumid){
        setAlbumid(albumid);
        setUrl(url);
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }
}
