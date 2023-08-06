package com.ext.prep.interview;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CoastalLocation extends Location{

    public CoastalLocation(String locationCd) {
        super(locationCd);
    }

    public double getCoastalLocationFactor(){
        return 1.0;
    }
}
