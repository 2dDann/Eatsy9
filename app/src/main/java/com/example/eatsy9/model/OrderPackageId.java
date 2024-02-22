package com.example.eatsy9.model;

import java.io.Serializable;
import java.util.Objects;

public class OrderPackageId implements Serializable {
    private static final long serialVersionUID = -8350602096867991947L;
    private Integer orderId;
    private Integer packageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPackageId entity = (OrderPackageId) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.packageId, entity.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, packageId);
    }

}