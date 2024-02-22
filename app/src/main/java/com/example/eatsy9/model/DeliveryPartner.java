package com.example.eatsy9.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class DeliveryPartner {
    private Integer id;
    private String partnerName;
    private String vehicleNo;
    private String partnerNo;
    private Set<Order> orders = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "DeliveryPartner{" +
                "id=" + id +
                ", partnerName='" + partnerName + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", partnerNo='" + partnerNo + '\'' +
                '}';
    }

}