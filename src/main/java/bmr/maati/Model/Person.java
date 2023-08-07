package bmr.maati.Model;

import bmr.maati.util.Observable;
import bmr.maati.util.Observer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntToDoubleFunction;

/**
 * This class is used to represent a person where all calculations are performed
 * and all attributes represent the characteristics of this person.
 * Implements Observable because the people are observed.
 */
public class Person implements Observable {

    private int height;
    private int weight;
    private int age;
    private String gender;
    private String activity;
    private String bmr;
    private String calories;

    private List<Observer> observers = new ArrayList<>();

    /**
     * Getter for the BMR, either the calculated value or the string "failed".
     *
     * @return the BMR of the person after calculation
     */
    public String getBmr() {
        return bmr;
    }

    /**
     * Getter for the calories, either the calculated value or the string "failed".
     *
     * @return the calories of the person after calculation
     */
    public String getCalories() {
        return calories;
    }

    /**
     * Method to set the attributes with the correct values, perform calculations for BMR and calories,
     * and then notify the observers.
     *
     * @param height   the height of the person
     * @param weight   the weight of the person
     * @param age      the age of the person
     * @param gender   the gender of the person
     * @param activity the activity level of the person
     */
    public void set(int height, int weight, int age, String gender, String activity) {
        calculate(height, weight, age, gender, activity);
        notifyObservers();
    }

    /**
     * Method to get the number used to calculate the BMR and calories of the person
     *
     * @param activity the type of activity the person usually does
     * @return a number needed for the calculation depending on how active the person is
     */
    public double activities(String activity) {
        switch (activity) {
            case "Sedentary":
                return 1.2;
            case "Lightly active":
                return 1.375;
            case "Moderately active":
                return 1.55;
            case "Very active":
                return 1.725;
            case "Super active":
                return 1.9;
            default:
                return 0;
        }
    }

    IntToDoubleFunction func = a -> 1.0 * a;


    /**
     * Method to calculate the BMR and calories of the person and then notify the observers.
     *
     * @param height   the height of the person
     * @param weight   the weight of the person
     * @param age      the age of the person
     * @param gender   the gender of the person
     * @param activity how active the person is
     */
    private void calculate(int height, int weight, int age, String gender, String activity) {
        if (gender.equals("Female")) {
            double multi_p = 9.6;
            this.weight = weight;
            double multi_t = 1.8;
            this.height = height;
            double multi_a = 4.7;
            this.age = age;
            double addit = 655;
            bmr = String.valueOf(formatTwoDecimals((multi_p * weight) + (multi_t * height) - (multi_a * age) + addit));
            double act = activities(activity);
            calories = formatTwoDecimals((func.applyAsDouble((int) (act * Double.valueOf(bmr.replace(",", "."))))));
        } else if (gender.equals("Male")) {
            double multi_p = 13.7;
            this.weight = weight;
            double multi_t = 5.0;
            this.height = height;
            double multi_a = 6.8;
            this.age = age;
            double addit = 66;
            this.bmr = String.valueOf((multi_p * weight) + (multi_t * height) - (multi_a * age) + addit);
            double act = activities(activity);
            calories = String.valueOf(((int) ((act * Double.valueOf(bmr)) * 100)) / 100.);
        }
        notifyObservers();
    }


    /**
     * Formats a double value to have exactly two decimal places.
     *
     * @param value the double value to be formatted
     * @return a string representation of the value with two decimal places
     */
    private String formatTwoDecimals(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(value);
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
