package Helpers.Enums.Statics;

import Selenium.Base;

public enum Icon {

    PARCELMACHINE("assets/icons/Paczkomat.svg?v=1.10.0"),
    BOXMACHINE("assets/icons/boxmachine.svg?v=1.10.0"),
    ADDRESS("assets/icons/address.svg?v=1.10.0"),
    HOME("assets/icons/Dom.svg?v=1.10.0"),
    PARCEL_C("assets/icons/parcel_C.svg?v=1.10.0"),
    PARCEL_B("assets/icons/parcel_B.svg?v=1.10.0"),
    PARCEL_A("assets/icons/parcel_A.svg?v=1.10.0");

    public final String url;

    Icon(String url) {
        this.url = Base.environment.getUrl() + url;
    }
}
