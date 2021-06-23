package Helpers.Enums;

public enum Dimension {
    PARCEL_A("8 x 38 x 64", "25", 12.99, 14.99),
    PARCEL_B("19 x 38 x 64", "25", 13.99, 16.49),
    PARCEL_C("41 x 38 x 64", "25", 15.49, 19.99);


    public final String dimension;
    public final String weight;
    public final double priceParcelmachine;
    public final double priceAddress;

    Dimension(String dimension, String weight, double priceParcelmachine, double priceAddress) {
        this.dimension = dimension;
        this.weight = weight;
        this.priceParcelmachine = priceParcelmachine;
        this.priceAddress = priceAddress;
    }
}
