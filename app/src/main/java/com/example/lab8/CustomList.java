package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the city
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * checks to see if city is in the list
     * @param city
     */
    public boolean hasCity(City city){
        if (cities.contains(city)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Deletes the given city from the list of cities
     * @param city the city to delete
     * @throws IllegalArgumentException if the given city is not in the list
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
        else{
            throw new IllegalArgumentException();
        }

    }

    /**
     * Counts the number of city's in the list of cities
     * @return (int) the number of city's in the list
     */
    public int countCities() {
        return cities.size();
    }


}
