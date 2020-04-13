package com.brands.dao;
// Generated Apr 14, 2020, 12:58:51 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CreditAdding generated by hbm2java
 */
@Entity
@Table(name="credit_adding"
    ,catalog="brands"
)
public class CreditAdding  implements java.io.Serializable {


     private String code;
     private double value;

    public CreditAdding() {
    }

    public CreditAdding(String code, double value) {
       this.code = code;
       this.value = value;
    }
   
     @Id 

    
    @Column(name="code", unique=true, nullable=false, length=11)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    
    @Column(name="value", nullable=false, precision=22, scale=0)
    public double getValue() {
        return this.value;
    }
    
    public void setValue(double value) {
        this.value = value;
    }




}


