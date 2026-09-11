import java.io.Serializable;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
public class Book implements Serializable{
    public String title;
    public String author;
    public int year;
    public Book (String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public String getTitle(){
        return this.title;
    }
    public void getBookInfo(){
        System.out.println(this.title + " was written by " + this.author + " in " + this.year);
    }

}
