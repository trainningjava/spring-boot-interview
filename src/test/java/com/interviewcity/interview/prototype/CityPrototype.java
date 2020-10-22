package com.interviewcity.interview.prototype;

import com.interviewcity.interview.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityPrototype {

    public static City citySP1() {
        City c = new City();
        c.setName("Diadema");
        c.setState("SP");
        return c;
    }

    public static City citySP2() {
        City c = new City();
        c.setName("Bauru");
        c.setState("SP");
        return c;
    }

    public static City citySC() {
        City c = new City();
        c.setName("Gaspar");
        c.setState("SC");
        return c;
    }

    public static List<City> cityList() {
        List<City> c = new ArrayList<>();
        c.add(citySP1());
        return c;

    }
}
