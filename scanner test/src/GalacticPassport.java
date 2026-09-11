        import java.util.Scanner;

        public class GalacticPassport {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String name = "";
                while (!name.equalsIgnoreCase("exit")) {

                    // Step 1: Welcome message
                    System.out.println("🛸 Welcome to Earth Immigration Control!");

                    // Step 2: Ask for name
                    System.out.print("Enter your full name: ");
                    name = scanner.nextLine().trim();

                    if (name.equalsIgnoreCase("exit")) {
                        break;
                    }

                    // Step 3: Ask for species
                    System.out.print("What species are you? ");
                    String species = scanner.nextLine();

                    // Step 4: Ask for age
                    System.out.print("How old are you (in Earth years)? ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    // Step 5: Ask for whether they come in peace
                    System.out.print("Do you come in peace? (true/false): ");
                    boolean comesInPeace = scanner.nextBoolean();
                    scanner.nextLine();
                    while (!comesInPeace) {

                        System.out.println("Access denied. Earth only accepts peaceful visitors. Try again");
                        System.out.print("Do you come in peace? (true/false): ");
                        comesInPeace = scanner.nextBoolean();
                    }

                    // Step 6: Print summary
                    System.out.println("\n🔍 Generating Galactic Passport...");
                    System.out.println("Name: " + name);
                    System.out.println("Species: " + species);
                    System.out.println("Age: " + age + " years");
                    System.out.println("Peaceful: " + comesInPeace);
                }

            }
        }



