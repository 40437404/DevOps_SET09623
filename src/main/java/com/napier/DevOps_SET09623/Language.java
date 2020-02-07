package com.napier.DevOps_SET09623;
import java.util.Comparator;
public class Language {

    private String name;
    private long number;
    private float percentage;

    public Language() {
        this.name = name;
        this.number = number;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public static Comparator<Language> percentageSort = new Comparator<Language>() {

        public int compare(Language s1, Language s2) {
            Float percentage1 = s1.getPercentage();
            Float percentage2 = s2.getPercentage();

            //descending order
            return percentage2.compareTo(percentage1);
        }
    };

    @Override
    public String toString() {
        return "Language = " + name + ", Population Number = " + number + ", Percentage = " + percentage;
    }
}
