package br.com.instabuy.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductEntity {
    public String id;
    public String name;
    public String brand;
    public List<Price> pc;
    public String thumb;
}
