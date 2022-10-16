public class Dog extends RescueAnimal {
    // Prefer immutable by default
    private final String breed;

    public Dog(
            String name,
            String breed,
            String gender,
            float age,
            float weight,
            String acquisition_date,
            String acquisition_country,
            String training_status,
            boolean reserved,
            String in_service_country) {
        super(
                name, "dog", gender, age, weight, acquisition_date,
                acquisition_country, training_status, reserved, in_service_country);
        // Prefer direct initialization over setters
        this.breed = breed;
    }

    public String get_breed() {
        return breed;
    }
}