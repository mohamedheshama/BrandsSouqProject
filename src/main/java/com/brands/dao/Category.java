package com.brands.dao;
// Generated Apr 9, 2020, 8:56:42 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name="category"
    ,catalog="brands"
)
public class Category  implements java.io.Serializable {


     private int categoryId;
     private String name;
     private Set<Products> productses = new HashSet<Products>(0);

    public Category() {
    }

	
    public Category(int categoryId) {
        this.categoryId = categoryId;
    }
    public Category(int categoryId, String name, Set<Products> productses) {
       this.categoryId = categoryId;
       this.name = name;
       this.productses = productses;
    }
   
     @Id 

    
    @Column(name="category_id", unique=true, nullable=false)
    public int getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    public Set<Products> getProductses() {
        return this.productses;
    }
    
    public void setProductses(Set<Products> productses) {
        this.productses = productses;
    }




}


