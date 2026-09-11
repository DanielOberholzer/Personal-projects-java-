import java.io.Serializable;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Main implements Serializable{
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        Book test = new Book("yummy", "Johnny", 1999);
        Book doawk = new Book("Diary of a wimpy kid", "Jeff Kinny" , 2005);
        Book animalFarm = new Book("Animal farm", "George Orwell", 1984);
        ArrayList<Book> bookList = new ArrayList<Book>();
        ArrayList<Book> bookListCopy = new ArrayList<Book>();
        bookList.add(test);
        bookList.add(doawk);
        bookList.add(animalFarm);
        FileOutputStream fileOutputStream = new FileOutputStream("library.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        FileInputStream fileInputStream = new FileInputStream("library.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        for(int i=0; i<bookList.size(); i++){
            objectOutputStream.writeObject(bookList.get(i));
            System.out.println("Serializing...");
        }
        for(int i=0; i<bookList.size(); i++){
            bookListCopy.add((Book)objectInputStream.readObject());
            System.out.println("Deserializing...");
        }
        for(int i=0; i<bookListCopy.size(); i++){
            bookListCopy.get(i).getBookInfo();
            System.out.println();

        }
    }
}
