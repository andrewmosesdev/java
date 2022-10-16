public class Monkey extends RescueAnimal {
    // Prefer immutable by default
    private final float tail_length;
    private final float height;
    private final float body_length;
    private final String species;

    public Monkey(
            String name,
            String gender,
            float age,
            float weight,
            String acquisition_date,
            String acquisition_country,
            String training_status,
            boolean reserved,
            String in_service_country,
            float tail_length,
            float height,
            float body_length,
            String species) {
        super(
                name, "monkey", gender, age, weight, acquisition_date, acquisition_country,
                training_status, reserved, in_service_country);

        // Prefer direct initialization over setters
        this.tail_length = tail_length;
        this.height = height;
        this.body_length = body_length;
        this.species = species;
    }

    public float get_tail_length() {
        return tail_length;
    }

    public float get_height() {
        return height;
    }

    public float get_body_length() {
        return body_length;
    }

    public String get_species() {
        return species;
    }
}
