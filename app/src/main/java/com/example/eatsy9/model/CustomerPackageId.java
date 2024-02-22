package com.example.eatsy9.model;

import java.io.Serializable;
import java.util.Objects;

public class CustomerPackageId implements Serializable {
    private static final long serialVersionUID = -6961320840507552137L;
    private Integer customerId;
    private Integer packageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerPackageId entity = (CustomerPackageId) o;
        return Objects.equals(this.customerId, entity.customerId) &&
                Objects.equals(this.packageId, entity.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, packageId);
    }

    public CustomerPackageId() {

    }

    public CustomerPackageId(Integer customerId, Integer packageId) {
        this.customerId = customerId;
        this.packageId = packageId;
    }
}