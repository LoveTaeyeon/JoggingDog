package edu.fjnu.Entity.Usual;

public class HealthPassage {

    private String number;
    private String title;
    private String author;
    private String imageStr;
    private String passage;

    public HealthPassage() {

    }

    public HealthPassage(String number, String title, String author, String imageStr, String passage) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.imageStr = imageStr;
        this.passage = passage;
    }

    //get 和  set 方法

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageStr() {
        return imageStr;
    }

    public void setImageStr(String imageStr) {
        this.imageStr = imageStr;
    }

    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }

    @Override
    public String toString() {
        return "HealthPassage{" +
                "number='" + number + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", imageStr='" + imageStr + '\'' +
                ", passage='" + passage + '\'' +
                '}';
    }
}
