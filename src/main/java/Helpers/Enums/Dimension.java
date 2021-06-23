package Helpers.Enums;

public enum Dimension {
    PARCEL_A("8 x 38 x 64", "25"),
    PARCEL_B("19 x 38 x 64", "25"),
    PARCEL_C("41 x 38 x 64", "25");


    public final String dimension;
    public final String weight;

    Dimension( String dimension, String weight) {
        this.dimension = dimension;
        this.weight = weight;
    }
}
