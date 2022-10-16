import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Driver {
    private ArrayList<Dog> dogs_list = new ArrayList<Dog>();
    private ArrayList<Monkey> monkeys_list = new ArrayList<Monkey>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Driver().run();
    }

    public void run() {
        while (true) {

            display_menu();
            String user_input = scanner.nextLine();

            // Switch is a lot more readable than if/else
            switch (user_input) {
                case "q": {
                    out.println("Have a great day!");
                    return;
                }
                case "1":
                    intake_new_dog();
                    break;
                case "2":
                    intake_new_monkey();
                    break;
                case "3":
                    reserve_animal();
                    break;
                case "4":
                    print_animals("dog");
                    break;
                case "5":
                    print_animals("monkey");
                    break;
                case "6":
                    print_animals("unreserved");
                    break;
                default:
                    out.println("Not a valid input");
                    break;
            }
        }
    }

    public static void display_menu() {
        out.printf(
                "\t\t\t\tRescue Animal System Menu"
                        + "%n[1] Intake a new dog"
                        + "%n[2] Intake a new monkey"
                        + "%n[3] Reserve an animal"
                        + "%n[4] Print a list of all dogs"
                        + "%n[5] Print a list of all monkeys"
                        + "%n[6] Print a list of all animals that are not reserved"
                        + "%n[q] Quit application"
                        + "%n"
                        + "%nEnter a menu selection: ");
    }

    public void intake_new_dog() {
        out.println("What is the dog's name?");
        String name = scanner.nextLine();

        dogs_list.forEach(entry -> {
            if (entry.get_name().equalsIgnoreCase(name)) {
                out.println("This dog is already in our system");
                return;
            }
        });

        out.println("What is the dog's gender?");
        String gender = scanner.nextLine();

        out.println("What is the dog's breed?");
        String breed = scanner.nextLine();

        out.println("What is the dog's age?");
        float age = scanner.nextFloat();
        scanner.nextLine();

        out.println("What is the dog's weight (in pounds)?");
        float weight = scanner.nextFloat();
        scanner.nextLine();

        out.println("What is the dog's acquisition date?");
        String acquisition_date = scanner.nextLine();

        out.println("What is the dog's acquisition Country?");
        String acquisition_country = scanner.nextLine();

        out.println("What is the dog's training status?");
        String training_status = scanner.nextLine();

        boolean reserved = input_yes_no("Is the dog reserved?");

        out.println("What is the dog's serviced Country?");
        String in_service_country = scanner.nextLine();

        Dog new_dog = new Dog(name, breed, gender, age, weight, acquisition_date, acquisition_country,
                training_status, reserved, in_service_country);

        dogs_list.add(new_dog);
        out.println("Dog intake complete.");
    }

    private boolean input_yes_no(String prompt) {
        while (true) {
            out.println(prompt);
            out.println("Enter Y for yes and N for no.");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equalsIgnoreCase("y"))
                return true;
            if (answer.equalsIgnoreCase("n"))
                return false;

            out.println("Not a valid input.");
        }
    }

    public void intake_new_monkey() {
        out.println("What is the monkey's name?");
        String name = scanner.nextLine();

        monkeys_list.forEach(entry -> {
            if (entry.get_name().equalsIgnoreCase(name)) {
                out.println("This dog is already in our system");
                return;
            }
        });

        out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();

        out.println("What is the monkey's age?");
        float age = scanner.nextFloat();
        scanner.nextLine();

        out.println("What is the monkey's weight?");
        float weight = scanner.nextFloat();
        scanner.nextLine();

        out.println("What is the monkey's acquisition date?");
        String acquisition_date = scanner.nextLine();

        out.println("What is the monkey's acquisition Country?");
        String acquisition_country = scanner.nextLine();

        out.println("What is the monkey's training status?");
        String training_status = scanner.nextLine();

        boolean reserved = input_yes_no("Is the monkey reserved?");

        out.println("What is the monkey's serviced Country?");
        String in_service_country = scanner.nextLine();

        out.println("What is the monkey's tail length?");
        float tail_length = scanner.nextFloat();
        scanner.nextLine();

        out.println("What is the monkey's height?");
        float height = scanner.nextFloat();
        scanner.nextLine();

        out.println("What is the monkey's body length?");
        float body_length = scanner.nextFloat();
        scanner.nextLine();

        out.println("What is the monkey's species?");
        String species = scanner.nextLine();

        Monkey new_monkey = new Monkey(
                name, gender, age, weight, acquisition_date, acquisition_country,
                training_status, reserved, in_service_country, tail_length, height, body_length, species);

        monkeys_list.add(new_monkey);
        out.println("Monkey intake complete.");
    }

    public void reserve_animal() {
        while (true) {
            out.println("What is the desired animal type to reserve?");
            out.println("Please enter either Dog or Monkey");
            out.println();

            String desired_animal = scanner.nextLine().toLowerCase();
            switch (desired_animal) {
                case "dog": {
                    reserve_dog();
                    return;
                }
                case "monkey": {
                    reserve_monkey();
                    return;
                }
                default:
                    out.println("Not a valid input");
                    return;
            }
        }
    }

    public void reserve_dog() {
        out.println("In what country do you want to reserve a dog?");
        String desired_country = scanner.nextLine();

        Optional<Dog> checked_dog = dogs_list.stream()
                .filter(dog -> dog.get_in_service_location().equalsIgnoreCase(desired_country)
                        && !dog.is_reserved())
                .findFirst();

        if (checked_dog.isPresent()) {
            out.println("An unreserved dog has been found in that country");
            checked_dog.get().reserve();
            out.printf("Your newly reserved dog is: %s%n", checked_dog.get().get_name());
        } else {
            out.println("There are no unreserved dogs in that country.");
        }
    }

    public void reserve_monkey() {
        out.println("In what country do you want to reserve a monkey?");
        String desired_country = scanner.nextLine();

        Optional<Monkey> checked_monkey = monkeys_list.stream()
                .filter(monkey -> monkey.get_in_service_location().equalsIgnoreCase(desired_country)
                        && !monkey.is_reserved())
                .findFirst();

        if (checked_monkey.isPresent()) {
            out.println("An unreserved monkey has been found in that country");
            checked_monkey.get().reserve();
            out.printf("Your newly reserved monkey is: %s%n", checked_monkey.get().get_name());
        } else {
            out.println("There are no unreserved monkeys in that country.");
        }
    }

    public void print_animals(String key) {
        String desired_printout = key;

        switch (desired_printout) {
            case "dog": {
                dogs_list.forEach(entry -> {
                    System.out.println();
                    System.out.println("Name: " + entry.get_name());
                    System.out.println("Gender: " + entry.get_gender());
                    System.out.println("Breed: " + entry.get_breed());
                    System.out.println("Age: " + entry.get_age());
                    System.out.println("Weight (lbs): " + entry.get_weight());
                    System.out.println("Acquisition Date: " + entry.get_acquisition_date());
                    System.out.println("Acquisition Country: " + entry.get_acquisition_location());
                    System.out.println("Training status: " + entry.get_training_status());
                    System.out.println("Reserved: " + entry.is_reserved());
                    System.out.println("Serviced Country: " + entry.get_in_service_location());
                    System.out.println();
                    System.out.println("---------");
                });
                return;
            }
            case "monkey": {
                monkeys_list.forEach(entry -> {
                    System.out.println();
                    System.out.println("Name: " + entry.get_name());
                    System.out.println("Gender: " + entry.get_gender());
                    System.out.println("Age: " + entry.get_age());
                    System.out.println("Weight (lbs): " + entry.get_weight());
                    System.out.println("Acquisition Date: " + entry.get_acquisition_date());
                    System.out.println("Acquisition Country: " + entry.get_acquisition_location());
                    System.out.println("Training status: " + entry.get_training_status());
                    System.out.println("Reserved: " + entry.is_reserved());
                    System.out.println("Serviced Country: " + entry.get_in_service_location());
                    System.out.println("Tail Length: " + entry.get_tail_length());
                    System.out.println("Height: " + entry.get_height());
                    System.out.println("Body Length: " + entry.get_body_length());
                    System.out.println("Species: " + entry.get_species());
                    System.out.println();
                    System.out.println("---------");
                });
                return;
            }
            case "unreserved": {
                System.out.println("The following animals are not reserved: ");
                List<RescueAnimal> combined_list = Stream.of(dogs_list, monkeys_list)
                        .flatMap(x -> x.stream())
                        .collect(Collectors.toList());
                combined_list.forEach(entry -> {
                    if (entry.is_reserved() == true) {
                        System.out.println(entry.get_name());
                    }
                });
                return;
            }
        }
    }
}