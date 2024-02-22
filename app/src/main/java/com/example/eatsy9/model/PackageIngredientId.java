package com.example.eatsy9.model;

import java.io.Serializable;
import java.util.Objects;

public class PackageIngredientId implements Serializable {
    private static final long serialVersionUID = -1859066254759330554L;
    private Integer packageId;
    private Integer ingredientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageIngredientId entity = (PackageIngredientId) o;
        return Objects.equals(this.ingredientId, entity.ingredientId) &&
                Objects.equals(this.packageId, entity.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, packageId);
    }

    public PackageIngredientId() {

    }

    public PackageIngredientId(Integer packageId, Integer ingredientId) {
        this.packageId = packageId;
        this.ingredientId = ingredientId;
    }

}