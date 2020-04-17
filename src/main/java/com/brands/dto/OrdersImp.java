package com.brands.dto;


import com.brands.dao.OrderDetails;
import com.brands.dao.Products;
import com.brands.dao.Users;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class OrdersImp implements OrdersDto {
    Session session = MySessionFactory.getMySession();

    @Override
    public Products getProductByProductId(int product_id) {
        String hql = " from com.brands.dao.OrderDetails p where p.products.id=?";
        Query query = session.createQuery(hql).setParameter(0, product_id);
        Products products = (Products) query.uniqueResult();

        return products;


    }

    @Override
    public boolean addProductByProductIdToOrders(OrderDetails orderDetails, Users user) {

        session.beginTransaction();
        Users users= (Users) session.load(Users.class,user.getUserId());

//        session.persist(seller);
//        session.getTransaction().commit();
//        String hql = " from com.brands.dao.OrderDetails p where p.products.id=?";
//        Query query = session.createQuery(hql).setParameter(0, product_id);
        return false;
    }

    @Override
    public boolean removeProductByProductIdFromOrders(int product_id, Users user) {
        return false;
    }


    @Override
    public boolean updateQuantityByProductId(int product_id, Users user, int quantity) {
        return false;
    }

    @Override
    public List<Products> getAllProductByUserId(Users user) {
        return null;
    }

    @Override
    public void updateNoOfProductsInOrders(int product_id, Users user) {

    }


    @Override
    public Double calculateSumOfProducts(Users user) {
        return null;
    }


//    Session session = MySessionFactory.getMySession();
//
//    public Orders getCart(Users user) {
//        String hql = "select orderses from com.brands.dao.Users c where c.userId=?";
//        Query query = session.createQuery(hql).setParameter(0, user.getUserId());
//        Set<Orders> userOrders = (Set<Orders>) query.uniqueResult();
//        if (userOrders != null) {
//            Orders currentOrder = null;
//            for (Orders order : userOrders) {
//                if (order.getBought() == 1) {
//                    return order;
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Products getProductByProductId(int product_id) { // later
//        Products product = (Products) session.get(Products.class, product_id);
//        if (ValidateProduct.isExist(product)) {
//            return product;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public boolean addProductByProductIdToCart(int product_id, Users user) {//later
//        if (!ValidateUser.isExist(user)) {
//            return false;
//        } else {
//            Orders cart = getCart(user);
//            Set<Products> cartProducts = cart.getProductses();
//            Products product = (Products) session.get(Products.class, product_id);
//            cartProducts.add(product);
//            cart.setProductses(cartProducts);
//            session.beginTransaction();
//            session.update(cart);
//            session.update(user);
//            session.getTransaction().commit();
//            return true;
//        }
//    }
//
//    @Override
//    public boolean removeProductByProductIdFromCart(int product_id, Users user) {//later
//        if (!ValidateUser.isExist(user)) {
//            return false;
//        } else {
//            Cart cart = user.getCart();
//            Set<Products> cartProducts = cart.getProductses();
//            Products product = (Products) session.get(Products.class, product_id);
//            if (cartProducts.contains(product)) {
//                cartProducts.remove(product);
//                cart.setProductses(cartProducts);
//                session.beginTransaction();
//                session.update(cart);
//                session.update(user);
//                session.getTransaction().commit();
//                return true;
//            } else {
//                System.out.println("product not in cart already");
//                return false;
//            }
//
//        }
//    }
//
//    private boolean isProductRemovedFromCart(Products product, Users user) {
//        return !user.getCart().getProductses().contains(product);
//    }
//
//    @Override
//    public boolean updateQuantityByProductId(int product_id, Users user,int quantity) {
//        Products product = (Products) session.get(Products.class, product_id);
//        Cart cart = user.getCart();
//        Set<Products> cartProducts = cart.getProductses();
//        if (!ValidateUser.isExist(user) || isProductRemovedFromCart(product, user)) {
//            return false;
//        } else {
//            for (Products aproduct: cartProducts) {
//                if(aproduct.getProductId()== product_id){
//                    aproduct.setQuantity(quantity);
//                }
//            }
//
//            session.beginTransaction();
//
//            session.update(user);
//            session.getTransaction().commit();
//
//            return true;
//        }
//    }
//
//    @Override
//    public List<Products> getAllProductByUserId(Users user) {
//
//        return null;
//    }
//
//    @Override
//    public void updateNoOfProductsInCart(int product_id, Users user) {
//
//    }
//
//    @Override
//    public Double calculateSumOfProducts(Users user) {
//        return null;
//    }
}
