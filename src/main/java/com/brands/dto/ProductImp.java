package com.brands.dto;

import com.brands.dao.Category;
import com.brands.dao.Orders;
import com.brands.dao.Products;
import com.brands.dao.Users;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class ProductImp implements ProductDto {
    Session session = MySessionFactory.getMySession();


    @Override
    public Products getProductById(int product_id) {
        String hql = " from com.brands.dao.Products p where p.productId=?";
        Query query = session.createQuery(hql).setParameter(0, product_id);
        return (Products) query.list().get(0);
    }

    @Override
    public List<Products> searchProductByName(String name) {
        String hql = " from com.brands.dao.Products p where p.name=?";
        Query query = session.createQuery(hql).setParameter(0, name);
        List<Products> products = query.list();
        return products;
    }

    @Override
    public List<Products> searchProductByPrice(Double price) {
        String hql = " from com.brands.dao.Products p where p.price=?";
        Query query = session.createQuery(hql).setParameter(0, price);
        List<Products> products = query.list();
        return products;
    }

    @Override
    public List<Products> getAllProducts() {
        String hql = "from  com.brands.dao.Products";
        Query query = session.createQuery(hql);
        List<Products> products =  query.list();
        return products;
    }

    @Override
    public List<Products> getAllProductsByCategoryId(int category_id) {
        String hql = " from com.brands.dao.Products p where p.category.id=?";
        Query query = session.createQuery(hql).setParameter(0, category_id);
        List<Products> products = query.list();
        return products;
    }

    @Override
    public Products addProduct(Products product) {
//        session.beginTransaction();
//        session.persist(product);
//Category category=product.getCategory();
//        category.getProductses().add(product);
//        session.update(category);
//        session.update(product);
//        session.getTransaction().commit();

        System.out.println("inside");
        Category category1 = (Category) session.load(Category.class, product.getCategory().getCategoryId());
        Products products = new Products(category1,product.getCreateDate(), product.getName(), product.getPrice());
        products.setCategory(category1);
        products.setImage(product.getImage());
        products.setDescription(product.getDescription());
        session.beginTransaction();
        session.persist(products);
        category1.getProductses().add(products);
        session.update(category1);
        session.update(products);
        session.getTransaction().commit();










//        System.out.println("inside");
//        Category category1 = (Category) session.load(Category.class, );
//        Products products = new Products(category1,new Date(), "jeans", 12);
//        products.setCategory(category1);
//
//        category1.getProductses().add(products);
//        session.update(category1);
//        session.update(products);
//        session.getTransaction().commit();








//
//        Category category = (Category) session.load(Category.class,product.getCategory().getCategoryId());
//        Products newProduct = new Products();
//        newProduct.setCreateDate(product.getCreateDate());
//        newProduct.setName(product.getName());
//        newProduct.setPrice(product.getPrice());
//        newProduct.setCategory(category);
////        newProduct.setDescription(product.getDescription());
////        newProduct.setImage(product.getImage());
//
//        session.beginTransaction();
//        session.persist(newProduct);
//        session.getTransaction().commit();

        return product;
    }

    @Override
    public boolean updateProduct(Products product) {
        int numOfRiws = -1;
        String hql = "update  com.brands.dao.Products p set p.createDate=?, " +
                "p.image=?, p.name=?, p.category.categoryId=?, p.description=? " +
                "where p.productId = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,product.getCreateDate());
        query.setParameter(1,product.getImage());
        query.setParameter(2,product.getName());
        query.setParameter(3,product.getCategory().getCategoryId());
        query.setParameter(4,product.getDescription());
        query.setParameter(5,product.getProductId());
        System.out.println("updated");
        numOfRiws = query.executeUpdate();
        System.out.println("no rows "+numOfRiws);
        if(numOfRiws == -1){
            System.out.println("no update");
            return false;
        }else{
            System.out.println("up");
//            session.beginTransaction();
//            session.update(product);
//            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteProduct(int product_id) {
        int numOfRiws = -1;
        String hql = "delete from  com.brands.dao.Products p where p.productId =? " ;
        Query query = session.createQuery(hql).setParameter(0, product_id);
        numOfRiws = query.executeUpdate();
        if(numOfRiws == -1){
            return false;
        }else
            return true;
    }

}
