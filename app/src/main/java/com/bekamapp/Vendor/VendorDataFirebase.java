package com.bekamapp.Vendor;

import com.bekamapp.WorkingHours;

import java.util.ArrayList;
import java.util.List;

public class VendorDataFirebase {
    private String name, phone, location;
    private List<String> categories;
    private WorkingHours workingHours;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public WorkingHours getWorkingHours() {
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

    public void setWorkingHours(List<String> days, String from, String to) {
        this.workingHours = new WorkingHours();
        this.workingHours.setWorkingDays(days);
        this.workingHours.setFrom(from);
        this.workingHours.setTo(to);
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = new ArrayList<>();
        this.categories = categories;
    }
}