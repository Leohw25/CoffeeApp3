package com.example.coffeeapp01;

public class Order {
    //attributes
    private int _id;
    private String _custName;
    private int _saleAmount;

    //default constructor
    public Order(){
        this._id = 0;
        this._custName = null;
        this._saleAmount = 0;
    }

    //2nd Constructor
    public Order(String _custName, int _saleAmount) {
        this._custName = _custName;
        this._saleAmount = _saleAmount;
    }

    //get methods

    public int get_id() {
        return _id;
    }

    public String get_custName() {
        return _custName;
    }

    public int get_saleAmount() {
        return _saleAmount;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_custName(String _custName) {
        this._custName = _custName;
    }

    public void set_saleAmount(int _saleAmount) {
        this._saleAmount = _saleAmount;
    }
}
