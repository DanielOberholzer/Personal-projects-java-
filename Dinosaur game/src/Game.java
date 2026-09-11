import java.util.*;

public class Game {
    static String[][] dinoPark =
                    {{"EMPTY SLOT 0 0","EMPTY SLOT 0 1","EMPTY SLOT 0 2"},
                    {"EMPTY SLOT 1 0","EMPTY SLOT 1 1","EMPTY SLOT 1 2"},
                    {"EMPTY SLOT 2 0","EMPTY SLOT 2 1","EMPTY SLOT 2 2"}};
    Map<String, Dinosaur> enclosures = new HashMap<>();
    public static void viewPark(){
        for(int i=0; i<dinoPark.length; i++){
            for(int j=0; j<dinoPark[0].length; j++) {

                System.out.print(dinoPark[i][j] + "\t");
            }
            System.out.println();
        }
    }

    Scanner scanner = new Scanner(System.in);
    public void buildEnclosure(){
        System.out.println("What would you like to build? \n1.Carnivore cage. (2X2)\n2.Herbivore habitat. (1X2)\n3.Ariel arena. (2X1)\n"//Staff room. (1x1)
                 );
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1) {
            System.out.println("Which slot? (the slot you pick will be the top left of the enclosure)");
            int row = scanner.nextInt();
            scanner.nextLine();
            int col = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the names of 4 dinosaurs to add:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    String dinoName = scanner.nextLine();
                    Dinosaur chosen = Dinosaur.findByName(dinoName);

                    if (chosen != null) {
                        dinoPark[row + i][col + j] = "Carnivore cage (" + chosen.name + ")";
                        enclosures.put((row + i) + " " + (col + j), chosen);
                        System.out.println(chosen.name + " added to slot (" + (row + i) + " " + (col + j) + ")");
                        new Thread(chosen).start();
                    } else {
                        System.out.println("No dinosaur found with that name!");
                    }
                }
            }


        } else if (choice == 2) {
            System.out.println("Which slot? (the slot you pick will be the top left of the enclosure)");
            int row = scanner.nextInt();
            scanner.nextLine();
            int col = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the names of 2 dinosaurs to add:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 1; j++) {
                    String dinoName = scanner.nextLine();
                    Dinosaur chosen = Dinosaur.findByName(dinoName);

                    if (chosen != null) {
                        dinoPark[row + i][col + j] = "Herbivore habitat (" + chosen.name + ")";
                        enclosures.put((row + i) + " " + (col + j), chosen);
                        System.out.println(chosen.name + " added to slot (" + (row + i) + " " + (col + j) + ")");
                        new Thread(chosen).start();
                    } else {
                        System.out.println("No dinosaur found with that name!");
                    }
                }
            }
        }else if(choice == 3){
            System.out.println("Which slot? (the slot you pick will be the top left of the enclosure)");
            int row = scanner.nextInt();
            scanner.nextLine();
            int col = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the names of 2 dinosaurs to add:");
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < 2; j++) {
                    String dinoName = scanner.nextLine();
                    Dinosaur chosen = Dinosaur.findByName(dinoName);

                    if (chosen != null) {
                        dinoPark[row + i][col + j] = "Ariel arena (" + chosen.name + ")";
                        enclosures.put((row + i) + " " + (col + j), chosen);
                        System.out.println(chosen.name + " added to slot (" + (row + i) + " " + (col + j) + ")");
                        new Thread(chosen).start();
                    } else {
                        System.out.println("No dinosaur found with that name!");
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        //this is the initial game menu
        while(input != 6){
            System.out.println("Welcome to dino park game! This is your park: ");
            viewPark();
            System.out.println("What would you like to do?\n1.Purchase dinosaurs\n2.Build enclosures\n3.View park\n4.View tutorial\n6.Feed dinosaurs\n6.Exit");
            input = scanner.nextInt();
            scanner.nextLine();
            if(input == 1){
                System.out.println("Which dinosaur would you like to create?\n1.TRex\n2.Velociraptor\n3.Triceratops\n4.Pterodactyl");
                input = scanner.nextInt();
                scanner.nextLine();
                switch(input){
                    case 1:
                        TRex.genDinoT();
                        break;
                    case 2:
                        Raptor.genDinoR();
                        break;
                    case 3:
                        Triceratops.genDinoTR();
                        break;
                    case 4:
                        Pterodactyl.genDinoT();
                        break;
                }
                System.out.println("New list of dinosaurs:");
                for(Dinosaur d: Dinosaur.allDinos){
                    d.getInfo();
                }
            }else if(input == 2){
                game.buildEnclosure();
            } else if (input == 3) {
                viewPark();
                for(Dinosaur d: Dinosaur.allDinos){
                    d.getInfo();
                }

            } else if (input == 4) {
                System.out.println("Welcome to dino park manager! Your job is to run a park with dinosaurs in it! Ensure dinosaurs are fed, happy, and alive! That's about it really.");
            }else if(input == 5){
                for(Dinosaur d : Dinosaur.allDinos){
                    d.hunger += 30;
                }
            }else if(input == 6){
                break;
            }



        }

    }
}