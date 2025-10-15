package com.example.code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");

    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList List = new CityList();
        City existingCity = new City("Edmonton", "Alberta");
        City nonExistingCity = new City("Toronto", "Ontario");
        List.add(existingCity);
        // Test for a city that exists in the list
        assertTrue(List.hasCity(existingCity), "Should return true for a city that is in the list.");

        // Test for a city that does not exist in the list
        assertFalse(List.hasCity(nonExistingCity), "Should return false for a city not in the list.");
    }

    @Test
    void testDelete() {
        CityList cityList = new CityList();
        City cityToDelete = new City("Edmonton", "Alberta");
        cityList.add(cityToDelete);


        // Check that the city is there before deleting
        assertEquals(1, cityList.countCities());
        assertTrue(cityList.hasCity(cityToDelete));

        // Delete the city
        cityList.delete(cityToDelete);

        // Check that the city is gone and the count is updated
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(cityToDelete));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City nonExistentCity = new City("Calgary", "Alberta");

        // Assert that an IllegalArgumentException is thrown when trying to delete a city not in the list
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(nonExistentCity);
        }, "Deleting a non-existent city should throw an exception.");
    }

    @Test
    void testCountCities() {
        CityList List = new CityList();
        List.add(new City("Edmonton","Alberta"));
        // Initially, the list should have 1 city from the mock setup
        assertEquals(1, List.countCities(), "Count should be 1 after initial setup.");

        City Halifax = new City("Halifax", "Nova Scotia");
        // Add another city and check the count again
        List.add(Halifax);
        assertEquals(2, List.countCities(), "Count should be 2 after adding a new city.");

//         Delete a city and check the count again
        List.delete(Halifax);
        assertEquals(1, List.countCities(), "Count should be 1 after deleting a city.");
    }

}
