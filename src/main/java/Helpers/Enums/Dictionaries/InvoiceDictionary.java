package Helpers.Enums.Dictionaries;

import Models.Invoice;

public enum InvoiceDictionary {

    FOREIGN_COMPANY("mercedes", "DE", "Niemcy", "812526315", "test@test.de", "11-111", "Berlin", "Platz", "1", "1"),
    COMPANY("integer", "6782881784", "inpost@inpost.pl", "01-123", "Warszawa", "Elekcyjna", "1", "1"),
    INDIVIDUAL("osoba", "ktos@inpost.pl", "01-123", "Warszawa", "Elekcyjna", "1", "1");

    public final Invoice invoice;

    InvoiceDictionary(String name, String nip, String email, String zipCode, String city, String street, String buildingNo, String flatNo) {
        invoice = new Invoice(name, nip, email, zipCode, city, street, buildingNo, flatNo);
    }

    InvoiceDictionary(String name, String prefix, String country, String nip, String email, String zipCode, String city, String street, String buildingNo, String flatNo) {
        invoice = new Invoice(name, prefix, country, nip, email, zipCode, city, street, buildingNo, flatNo);
    }

    InvoiceDictionary(String name, String email, String zipCode, String city, String street, String buildingNo, String flatNo) {
        invoice = new Invoice(name, email, zipCode, city, street, buildingNo, flatNo);
    }
}
