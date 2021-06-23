package Helpers.Enums;

public enum StaticText {

    SIZE_PARCEL_A("Mała", "Small"),
    SIZE_PARCEL_B("Średnia", "Medium"),
    SIZE_PARCEL_C("Duża", "Large"),
    MATT_FRONT_TEXT("Wyślij paczkę szybko i wygodnie!", "Send parcels quickly and conveniently!"),
    SUMMARY_TRANSACTION_PENDING("Twoja transakcja nie została jeszcze zakończona.",
            "Your transaction has not been concluded"),
    SUMMARY_TRANSACTION_SUCCESS("Twoja płatność została potwierdzona", "Your payment was confirmed"),
    SUMMARY_TRANSACTION_FAILURE("Ups, mamy problem.","Oops, we have a problem.");

    public final String pl;
    public final String en;

    StaticText(String pl, String en) {
        this.pl = pl;
        this.en = en;
    }
}
