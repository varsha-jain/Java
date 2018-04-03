/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.State;

import Business.EcoSystem;
import Business.Enterprise.EnterpriseDirectory;
import Business.city.City;
import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class State {
    private String name;
    private ArrayList<City> cityList ;

    public State() {
        cityList = new ArrayList<City>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }
    
    public City createAndAddCity()
    {
        City city = new City();
        cityList.add(city);
        return city;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public boolean checkIfNetworkIsUnique(String stateName, String cityName, State state)
    {   
        boolean uniqueNetworkName = true;
        
        
                for(City city : state.getCityList())
                    
                {
                    if(city.getName().equalsIgnoreCase(cityName))
                    {
                        uniqueNetworkName = false;
                        break;
                    }
                    else
                    {
                        uniqueNetworkName = true;
                    }
                }       
        return uniqueNetworkName;
    }
    
}
