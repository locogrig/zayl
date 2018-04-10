package com.baizhi.common.entity;



public class Carousel {
    private String id;
    private String path;
    private String title;
    private String descs;
    private String filename;

    @Override
    public String toString() {
        return "Carousel{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", descs='" + descs + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Carousel(String id, String path, String title, String descs, String filename) {

        this.id = id;
        this.path = path;
        this.title = title;
        this.descs = descs;
        this.filename = filename;
    }

    public Carousel() {

    }
}
