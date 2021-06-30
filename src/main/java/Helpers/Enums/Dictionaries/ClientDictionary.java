package Helpers.Enums.Dictionaries;

import Models.Client;

public enum ClientDictionary {

    BOXMACHINE("anna krasowska", "123123123", "anna@anna.pl", "KRA01M"),
    ADDRESS("anna krasowska", "123123123", "anna@anna.pl", "01-123", "Warszawa", "Elekcyjna", "1", "1"),
    SENDER("jan kowalski", "321321321", "jan@jan.pl");

    public final Client client;

    ClientDictionary(String name, String phone, String email) {
        client = new Client(name, phone, email);
    }

    ClientDictionary(String name, String phone, String email, String parcelmachine) {
        client = new Client(name, phone, email, parcelmachine);
    }

    ClientDictionary(String name, String phone, String email, String zipCode, String city, String street, String buildingNo, String flatNo) {
        client = new Client(name, phone, email, zipCode, city, street, buildingNo, flatNo);
    }
}
