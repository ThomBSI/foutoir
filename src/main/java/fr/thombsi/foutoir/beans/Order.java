package fr.thombsi.foutoir.beans;

public class Order {
    private Long     id;
    private String   date;
    private double   amount;
    private String   payMethod;
    private String   payStatus;
    private String   deliveryMod;
    private String   deliveryStatus;
    private Customer customer;

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount( double amount ) {
        this.amount = amount;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod( String payMethod ) {
        this.payMethod = payMethod;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus( String payStatus ) {
        this.payStatus = payStatus;
    }

    public String getDeliveryMod() {
        return deliveryMod;
    }

    public void setDeliveryMod( String deliveryMod ) {
        this.deliveryMod = deliveryMod;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus( String deliveryStatus ) {
        this.deliveryStatus = deliveryStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer( Customer customer ) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

}
