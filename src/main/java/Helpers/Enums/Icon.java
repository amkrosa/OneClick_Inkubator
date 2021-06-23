package Helpers.Enums;

public enum Icon {

    PARCELMACHINE("https://inpost.pl/SzybkieNadania/assets/icons/Paczkomat.svg?v=1.10.0"),
    BOXMACHINE("https://inpost.pl/SzybkieNadania/assets/icons/boxmachine.svg?v=1.10.0"),
    ADDRESS("https://inpost.pl/SzybkieNadania/assets/icons/address.svg?v=1.10.0"),
    HOME("https://inpost.pl/SzybkieNadania/assets/icons/Dom.svg?v=1.10.0"),
    PARCEL_C("https://inpost.pl/SzybkieNadania/assets/icons/parcel_C.svg?v=1.10.0"),
    PARCEL_B("https://inpost.pl/SzybkieNadania/assets/icons/parcel_B.svg?v=1.10.0"),
    PARCEL_A("https://inpost.pl/SzybkieNadania/assets/icons/parcel_A.svg?v=1.10.0");

    public final String url;

    Icon( String url) {
        this.url = url;
    }
}
