package br.com.instabuy.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    public float price;
    public float valid_price;
}
