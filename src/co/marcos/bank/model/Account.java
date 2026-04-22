package co.marcos.bank.model;

import co.marcos.bank.util.Log;

public class Account {
    private static final int MAX_LENGTH = 12;

    private String ag;
    private String cc;
    private String name;
    private double balance;


    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);
        this.balance = 0;
    }

    public String getAg() {
        return ag;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name.length() > MAX_LENGTH){
            this.name = name.substring(0, MAX_LENGTH);
        }else{
            this.name = name;
        }
    }

    public boolean deposit(double value){
        if (value <= 0) return false;
        balance += value;
        return true;
    }

    public boolean withDraw(double value){
        if (value <= 0 || balance < value) return false;
        balance -= value;
        return true;
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", ag='" + ag + '\'' +
                ", cc='" + cc + '\'' +
                ", balance=" + balance +
                '}';
    }
}
