package InClass;

public class Country implements Comparable<Country> {
    private String name;
    private double area;
    public Country(String aName, double anArea) {
        name = aName;
        area = anArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public int compareTo(Country c) {
        if (area < c.area) return -1;
        if (area > c.area) return 1;
        return 0;
    }
}
