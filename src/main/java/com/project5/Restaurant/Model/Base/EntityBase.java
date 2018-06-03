package com.project5.Restaurant.Model.Base;

import java.io.Serializable;

public interface EntityBase<PK extends Serializable> extends Serializable {

    PK getId();

    void setId(PK pk);
}
