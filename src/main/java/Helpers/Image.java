package Helpers;

public enum Image {
    ICON_PARCELMACHINE("https://inpost.pl/SzybkieNadania/assets/icons/Paczkomat.svg?v=1.10.0"),
    ICON_BOXMACHINE("https://inpost.pl/SzybkieNadania/assets/icons/boxmachine.svg?v=1.10.0"),
    ICON_ADDRESS("https://inpost.pl/SzybkieNadania/assets/icons/address.svg?v=1.10.0"),
    ICON_HOME("https://inpost.pl/SzybkieNadania/assets/icons/Dom.svg?v=1.10.0"),
    ICON_PARCEL_C("https://inpost.pl/SzybkieNadania/assets/icons/parcel_C.svg?v=1.10.0"),
    ICON_PARCEL_B("https://inpost.pl/SzybkieNadania/assets/icons/parcel_B.svg?v=1.10.0"),
    ICON_PARCEL_A("https://inpost.pl/SzybkieNadania/assets/icons/parcel_A.svg?v=1.10.0"),
    BANNER_PARCELMACHINE("https://inpost.pl/SzybkieNadania/assets/icons/Paczkomat%20icon.svg?v=1.10.0"),
    BANNER_PRINTER("https://inpost.pl/SzybkieNadania/assets/icons/printer.svg?v=1.10.0"),
    BANNER_DATA("https://inpost.pl/SzybkieNadania/assets/icons/dane%20dostawy%20icon.svg?v=1.10.0"),
    BANNER_PARCEL("https://inpost.pl/SzybkieNadania/assets/icons/paczka.svg?v=1.10.0");

    public final String url;

    Image(String url) {
        this.url = url;
    }
}
