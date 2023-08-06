package com.ext.prep.interview;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String locationCd;

    public Location(String locationCd) {
        this.locationCd = locationCd;
    }

    public double getCoastalLocationFactor(){
        return 1.0;
    }
}
