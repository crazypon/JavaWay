package data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Student {
    private String name;
    private Integer courseLevel;
    private Double gpa;
    private List<String> activities;
    private Integer notebooks;
    private Gender gender;
    private Optional<Bike> bike;

    public static Supplier<Student> PedroPascal = () ->{
        Bike bike = new Bike();
        bike.setName("Audi");
        bike.setModel("R8");
        Student s = new Student(
            "Pedro", 4, 3.65, Arrays.asList("piano", "martial arts"), 5, Gender.MALE
        );
        s.setBike(Optional.ofNullable(bike));
        return s;
    };

    public Student(String name, Integer courseLevel, Double gpa, List<String> activities, Integer notebooks,
                   Gender gender) {
        this.name = name;
        this.courseLevel = courseLevel;
        this.gpa = gpa;
        this.activities = activities;
        this.notebooks = notebooks;
        this.gender = gender;
    }

    public Student(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(Integer courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public Integer getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Integer notebooks) {
        this.notebooks = notebooks;
    }

    public Optional<Bike> getBike() {
        return bike;
    }

    public void setBike(Optional<Bike> bike) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courseLevel=" + courseLevel +
                ", gpa=" + gpa +
                ", activities=" + activities +
                ", notebooks=" + notebooks +
                ", gender=" + gender +
                ", bike=" + bike +
                '}';
    }
}
