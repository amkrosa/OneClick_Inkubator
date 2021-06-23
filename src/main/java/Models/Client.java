package Models;

import java.io.Serializable;

public class Client implements Serializable {
    private String name, phone, email, zipCode, city, buildingNo, flatNo, parcelmachine;

    public Client(String name, String phone, String email, String zipCode, String city, String buildingNo, String flatNo) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.zipCode = zipCode;
        this.city = city;
        this.buildingNo = buildingNo;
        this.flatNo = flatNo;
        this.parcelmachine = "";

    }

    public Client(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.zipCode = "";
        this.city = "";
        this.buildingNo = "";
        this.flatNo = "";
        this.parcelmachine = "";

    }

    public Client(String name, String phone, String email, String parcelmachine) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.parcelmachine = parcelmachine;
        this.zipCode = "";
        this.city = "";
        this.buildingNo = "";
        this.flatNo = "";
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Client setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Client setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Client setCity(String city) {
        this.city = city;
        return this;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public Client setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
        return this;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public Client setFlatNo(String flatNo) {
        this.flatNo = flatNo;
        return this;
    }

    public String getParcelmachine() {
        return parcelmachine;
    }

    public Client setParcelmachine(String parcelmachine) {
        this.parcelmachine = parcelmachine;
        return this;
    }
}
