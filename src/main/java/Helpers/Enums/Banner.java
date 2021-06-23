package Helpers.Enums;

public enum Banner {
    BANNER_PARCEL("https://inpost.pl/SzybkieNadania/assets/icons/paczka.svg?v=1.10.0"),
    BANNER_DATA("https://inpost.pl/SzybkieNadania/assets/icons/dane%20dostawy%20icon.svg?v=1.10.0"),
    BANNER_PRINTER("https://inpost.pl/SzybkieNadania/assets/icons/printer.svg?v=1.10.0"),
    BANNER_PARCELMACHINE("https://inpost.pl/SzybkieNadania/assets/icons/Paczkomat%20icon.svg?v=1.10.0");

    public final String url;

    Banner( String url) {
        this.url = url;
    }
}
