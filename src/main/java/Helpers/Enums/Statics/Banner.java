package Helpers.Enums.Statics;

import Selenium.Base;

public enum Banner {
    BANNER_PARCEL("assets/icons/paczka.svg?v=1.10.0"),
    BANNER_DATA("assets/icons/dane%20dostawy%20icon.svg?v=1.10.0"),
    BANNER_PRINTER("assets/icons/printer.svg?v=1.10.0"),
    BANNER_PARCELMACHINE("assets/icons/Paczkomat%20icon.svg?v=1.10.0");

    public final String url;

    Banner( String url) {
        this.url = Base.environment.getUrl()+url;
    }
}
