package com.seeuletter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.seeuletter.net.APIResource;

import java.util.HashMap;
import java.util.Map;

public class Address extends APIResource {

    public static final String RESOURCE = "addresses";

    @JsonProperty private final String name;
    @JsonProperty private final String company;
    @JsonProperty private final String line1;
    @JsonProperty private final String line2;
    @JsonProperty private final String line3;
    @JsonProperty private final String city;
    @JsonProperty private final String state;
    @JsonProperty private final String postalCode;
    @JsonProperty private final String country;

    @JsonCreator
    public Address(
            @JsonProperty("name") final String name,
            @JsonProperty("company") final String company,
            @JsonProperty("address_line1") final String line1,
            @JsonProperty("address_line2") final String line2,
            @JsonProperty("address_line3") final String line3,
            @JsonProperty("address_city") final String city,
            @JsonProperty("address_state") final String state,
            @JsonProperty("address_postalcode") final String postalCode,
            @JsonProperty("address_country") final String country) {
        this.name = name;
        this.company = company;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", line3='" + line3 + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();

        public RequestBuilder() {
        }

        public RequestBuilder setName(String name) {
            params.put("name", name);
            return this;
        }

        public RequestBuilder setCompany(String company) {
            params.put("company", company);
            return this;
        }

        public RequestBuilder setLine1(String line1) {
            params.put("address_line1", line1);
            return this;
        }

        public RequestBuilder setLine2(String line2) {
            params.put("address_line2", line2);
            return this;
        }

        public RequestBuilder setLine3(String line3) {
            params.put("address_line3", line3);
            return this;
        }

        public RequestBuilder setCity(String city) {
            params.put("address_city", city);
            return this;
        }

        public RequestBuilder setPostalCode(String postalCode) {
            params.put("address_postalcode", postalCode);
            return this;
        }

        public RequestBuilder setCountry(String country) {
            params.put("address_country", country);
            return this;
        }

        public Map<String, Object> build() {
            return params;
        }
    }

}
