package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * create a city list, add a city
     * check if the added city is in the list
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City mockCity = new City("Estevan", "SK");
        list.addCity(mockCity);
        assertTrue(list.hasCity(mockCity));
    }

    @Test
    public void testDeleteCity() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        City city2 = new City("Yellowknife", "Northwest Territories");
        list.addCity(city2);
        list.delete(city);
        assertFalse(list.hasCity(city));
        assertTrue(list.hasCity(city2));
        list.delete(city2);
        assertFalse(list.hasCity(city2));
        assertThrows( IllegalArgumentException.class, () -> {
            list.delete(city); });
    }



}
