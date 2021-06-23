package Models;

import java.io.Serializable;

public class Invoice implements Serializable {
    private String name, prefix, country, nip, email, zipCode, city, buildingNo, flatNo;

    public Invoice(String name, String prefix, String country, String nip, String email, String zipCode, String city, String buildingNo, String flatNo) {
        this.name = name;
        this.prefix = prefix;
        this.country = country;
        this.nip = nip;
        this.email = email;
        this.zipCode = zipCode;
        this.city = city;
        this.buildingNo = buildingNo;
        this.flatNo = flatNo;
    }

    public Invoice(String name, String nip, String email, String zipCode, String city, String buildingNo, String flatNo) {
        this.name = name;
        this.nip = nip;
        this.email = email;
        this.zipCode = zipCode;
        this.city = city;
        this.buildingNo = buildingNo;
        this.flatNo = flatNo;
    }

    public Invoice(String name, String email, String zipCode, String city, String buildingNo, String flatNo) {
        this.name = name;
        this.email = email;
        this.zipCode = zipCode;
        this.city = city;
        this.buildingNo = buildingNo;
        this.flatNo = flatNo;
    }

    public String getName() {
        return name;
    }

    public Invoice setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public Invoice setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Invoice setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getNip() {
        return nip;
    }

    public Invoice setNip(String nip) {
        this.nip = nip;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Invoice setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Invoice setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Invoice setCity(String city) {
        this.city = city;
        return this;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public Invoice setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
        return this;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public Invoice setFlatNo(String flatNo) {
        this.flatNo = flatNo;
        return this;
    }
}
