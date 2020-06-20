package webapplication.project.spacefood.model;


import java.util.ArrayList;
import java.util.List;

public class Restaurant {

   private List<MenuItem> menu;
    private String name;
    private String address;
    private String zipCode;
    private String City;
    private String quote;
    private int id;
    private static int idCounter = 0;

    public Restaurant(String name, String address, String zipCode, String city, String quote) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        City = city;
        this.quote = quote;
        this.id = idCounter++;
        menu = new ArrayList<>();
    }

    public MenuItem getMenuItem(Integer iId){
        for (int i = 0; i < menu.size() ; i++) {
            if (iId == menu.get(i).getId()){
                return menu.get(i);
            }
        }
        return null;
    }

    public MenuItem getMenuName(String name){
        for (int i = 0; i < menu.size() ; i++) {
            if (name == menu.get(i).getName()){
                return menu.get(i);
            }
        }
        return null;
    }

    public void addMenuItem(MenuItem menuItem){
        menu.add(menuItem);
    }



    public List<MenuItem> getMenu() {
        return menu;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", City='" + City + '\'' +
                ", quote='" + quote + '\'' +
                ", id=" + id +
                '}';
    }
}



