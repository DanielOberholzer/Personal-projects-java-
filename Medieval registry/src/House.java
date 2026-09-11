import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class House {
    List<Knight> knightList = new ArrayList<>();

    String houseName;
    String motto;

    public House(String houseName,String motto){
        this.houseName = houseName;
        this.motto = motto;
    }


    public class Knight {
        House house;
        String knightName;
        int honorRating;

        public Knight(House house, String knightName, int honorRating) {
            this.house = house;
            this.knightName = knightName;
            this.honorRating = honorRating;
        }

        public void knightInfo() {
            System.out.println(this.knightName + " of house " + this.house.houseName + " has an honour rating of " + this.honorRating + ". Their house's motto is " + this.house.motto);
        }

        public void addKnight() {
            knightList.add(this);
        }

    }
    public void readList() {
        for (Knight k : knightList) {
            k.knightInfo();
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String, House> houseRegistry = new HashMap<>();

        House karling = new House("Karling", "Germany united!");
        houseRegistry.put("karling", karling);
           /* House abbasid = new House("Abbasid", "IDK");
            House.Knight kaiser = karling.new Knight(karling, "Kaiser", 1);
            kaiser.addKnight();
            House.Knight bob = abbasid.new Knight(abbasid, "Bob", 7);
            bob.addKnight();
            House.Knight billy = abbasid.new Knight(abbasid, "Billy", 10);
            billy.addKnight();
            karling.readList();
            System.out.println(billy.house.houseName);
            System.out.println(billy.knightName);
            kaiser.knightInfo();*/
        //test code
        int option = scanner.nextInt();

        while(option != 4) {
            System.out.println("Welcome to the Medieval Registry, select an option to continue!");
            System.out.println("1.Create a new house");
            System.out.println("2.Add knights to a house");
            System.out.println("3.View registered knights");
            System.out.println("4.Exit");

            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println("Enter the name of your house: ");
                String hName = scanner.nextLine().trim().toLowerCase();
                System.out.println("Input your house motto: ");
                String hMotto = scanner.nextLine();
                System.out.println("Creating house...");
                House newHouse = new House(hName, hMotto);
                houseRegistry.put(hName, newHouse);

            } else if (option == 2) {
                System.out.println("Enter knight's name: ");
                String kName = scanner.nextLine();
                System.out.println("Enter knight's honour level (out of 10): ");
                int kHonour = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Knight's house: ");
                String kHouse = scanner.nextLine();
                House newHouse = houseRegistry.get(kHouse);
                House.Knight newKnight = newHouse.new Knight(newHouse, kName, kHonour);
                newKnight.addKnight();

            } else if (option == 3) {
                System.out.println("Enter a registered house you'd like to check: ");
                String cHouse = scanner.nextLine().toLowerCase();
                House selectedHouse = houseRegistry.get(cHouse);

                if (selectedHouse != null) {
                    selectedHouse.readList();
                } else {
                    System.out.println("That house is not registered.");
                }

            }else if (option == 4) {
                break;
            }else if(option == 5) {
                for(int z=0; z<100; z++){
                    System.out.println(z);
                }
            }
        }

    }



}