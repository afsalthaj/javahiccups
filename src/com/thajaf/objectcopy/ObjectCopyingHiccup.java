package com.thajaf.objectcopy;

import java.util.ArrayList;

public class ObjectCopyingHiccup {

    // a copy of an object is actually a reference.. Please checkout this project and try to run.
    public static void main(String[] args) {
        Customer customer = new Customer("afsal", 21.36);
        System.out.println("the initial customer name is "+ customer.getName() + " name is  " + customer.getBalance());

        Customer anotherCustomer;
        anotherCustomer = customer;

        System.out.println("the initial anotherCustomer name is "+ anotherCustomer.getName() + " name is  " + anotherCustomer.getBalance());

        anotherCustomer.setBalance(222);
        System.out.println("the final customer name is "+ customer.getName() + " name is  " + customer.getBalance());
        System.out.println("the final anotherCustomer name is "+ anotherCustomer.getName() + " name is  " + anotherCustomer.getBalance());

        ArrayList<Integer> newArrayList = new ArrayList<>();

        newArrayList.add(1);
        newArrayList.add(2);
        newArrayList.add(3);

        for(int i = 0 ; i < newArrayList.size(); i ++) {
            System.out.println("i is "+ i + " value is  "+newArrayList.get(i));
        }

        // this has lots of computing process..in shifting the rows up etc
        newArrayList.add(1, 2);


    }
}


class Customer{
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}