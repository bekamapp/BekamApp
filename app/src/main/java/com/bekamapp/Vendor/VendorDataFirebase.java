package com.bekamapp.Vendor;

import java.util.ArrayList;
import java.util.List;

public class VendorDataFirebase {
    private String name, phone, location, workingHours;
    private List<String> categories;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = new ArrayList<>();
        this.categories = categories;
    }
}
