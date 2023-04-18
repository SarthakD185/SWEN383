package PersonalInfo;

/**
 * Stores the personal details that are used by the account throughout the app
 */
public class PersonalDetails {

    private int age;
    private String height;
    private double weight;
    private String birthdate;

    /**
     * Constructor
     * @param age - age of user
     * @param height - height of user
     * @param weight - starting weight of user
     * @param birthdate - birthdate of user
     */
    public PersonalDetails(int age, String height, double weight, String birthdate) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;
    }

    /**
     * set new age
     * @param age - new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * set new height
     * @param height - new height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * set the new weight
     * @param weight - new weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Set new birthdate
     * @param birthdate - new birthday
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Get Weight
     * @return - double weight
     */
    public double getWeight() {
        return weight;
    }
}
