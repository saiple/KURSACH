package com.kursach.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class Order {
    Long id;
    Integer seller;
    Integer buyer;
    Long product;
    String name;
    String price;
    String avatar;
    String activity;

    public static List<Order> from(List<ProductCart> productCarts, Integer buyer){
        List<Order> orders = new ArrayList<>();
        for(ProductCart productCart: productCarts){
           orders.add(Order.builder()
                   .price(productCart.getPrice())
                   .seller(productCart.getUserId())
                   .product(productCart.getProductId())
                   .name(productCart.getName())
                   .buyer(buyer)
                   .avatar(productCart.getAvatar())
                   .activity(productCart.getActivity())
                   .build());
        }
        return orders;
    }
}
