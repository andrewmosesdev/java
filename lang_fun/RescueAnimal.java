// Prefer snake_case throughout
public class RescueAnimal {
	// Prefer immutable by default
	private final String name;
	private final String animal_type;
	private final String gender;
	private final float age;
	private final float weight;
	private final String acquisition_date;
	private final String acquisition_country;
	private final String training_status;
	private final String in_service_country;
	// Exception -- need to toggle
	private boolean reserved;

	public RescueAnimal(
			String name,
			String animal_type,
			String gender,
			float age,
			float weight,
			String acquisition_date,
			String acquisition_country,
			String training_status,
			boolean reserved,
			String in_service_country) {

		// Prefer direct initialization over standard setters
		this.name = name;
		this.animal_type = animal_type;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.acquisition_date = acquisition_date;
		this.acquisition_country = acquisition_country;
		this.training_status = training_status;
		this.reserved = reserved;
		this.in_service_country = in_service_country;
	}

	public String get_name() {
		return name;
	}

	public String get_animal_type() {
		return animal_type;
	}

	public String get_gender() {
		return gender;
	}

	public float get_age() {
		return age;
	}

	public float get_weight() {
		return weight;
	}

	public String get_acquisition_date() {
		return acquisition_date;
	}

	public String get_acquisition_location() {
		return acquisition_country;
	}

	public boolean is_reserved() {
		return reserved;
	}

	public String get_in_service_location() {
		return in_service_country;
	}

	public String get_training_status() {
		return training_status;
	}

	// Exception case
	public void reserve() {
		reserved = true;
	}
}