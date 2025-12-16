package com.mycompany.GUI;


public class Calculator {
    public double add(double a,double b){
    return a+b;
    }
    public double substract (double a, double b){
        return a-b;
    }
    public double multiply( double a,double b){
        return a*b;
    }
    public double divide(double a,double b){
        if(b!=0)return a/b;
        else return Double.NaN;
    }
    public double modulo(double a,double b){
        if (b!=0)return a%b;
        else return Double.NaN;
    }
    public double power(double a,double b){
        return Math.pow(a, b);
    }
    public double sqrt(double a){
        return Math.sqrt(a);
        
    }
    public double log(double a){
        if(a>0)return Math.log10(a);
        else return Double.NaN;
    }
    public double ln(double a){
        if (a>0)return Math.log(a);
        else return Double.NaN;
    }
    public double exp(double a){
        return Math.exp(a);
    }
    public double abs(double a){
        return Math.abs(a);
    }
    public double round(double a){
        return Math.round(a);
    }
    public double ceil(double a){
        return Math.ceil(a);
    }
    public double floor(double a){
        return Math.floor(a);
    }
    public double sin(double a){
        return Math.sin(Math.toRadians(a));
    }
    public double cos(double a){
        return Math.cos(Math.toRadians(a));
    }
    public double tan(double a){
        return Math.tan(Math.toRadians(a));
    }
    
 
}
