package com.example.code;

/**
 * Represents a city with a name and a province.
 * This class implements the Comparable interface to allow sorting of City objects,
 * primarily based on the city name.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructs a new City object.
     *
     * @param city     The name of the city.
     * @param province The province or state where the city is located.
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;

    }

    /**
     * Compares this city to another city for order.
     * The comparison is based on the lexicographical order of the city names.
     *
     * @param o The city to be compared.
     * @return A negative integer, zero, or a positive integer as this city's name
     * is less than, equal to, or greater than the specified city's name.
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * Gets the name of the city.
     *
     * @return A String representing the city's name.
     */
    public String getCityName() {
        return city;
    }

    /**
     * Sets or updates the name of the city.
     *
     * @param name The new name for the city.
     */
    public void setCity(String name) {
        this.city = name;
    }

    /**
     * Gets the province of the city.
     *
     * @return A String representing the city's province.
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets or updates the province of the city.
     *
     * @param province The new province for the city.
     */
    public void setProvince(String province) {
        this.province = province;
    }

}

