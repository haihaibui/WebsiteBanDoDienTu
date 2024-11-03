package com.group4.service.imp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nhom4.Entity.Product;
import com.Nhom4.Service.productService;
import com.group4.service.GioHangService;

@Service
public class GioHangServiceImp implements GioHangService{
	private final Map<Integer, Product> cart = new HashMap<>();

    @Autowired
    private productService productService;

    @Override
    public Product add(Integer id) {
        Product product = cart.get(id);
        if (product == null) {
            product = productService.getProductById(id);
            if (product != null) {
                product.setQty(1);
                cart.put(id, product);
            }
        } else {
            product.setQty(product.getQty() + 1);
        }
        return product;
    }

    @Override
    public void remove(Integer id) {
        cart.remove(id);
    }

    @Override
    public Product update(Integer id, String qty) {
        Product product = cart.get(id);
        if (product != null) {
            if ("minus".equals(qty) && product.getQty() > 0) {
                product.setQty(product.getQty() - 1);
                if (product.getQty() == 0) {
                    remove(id);
                }
            } else if ("plus".equals(qty) && product.getQty() < 100) {
                product.setQty(product.getQty() + 1);
            }
        }
        return product;
    }

    @Override
    public void clear() {
        cart.clear();
    }

    @Override
    public Collection<Product> getItems() {
        return cart.values();
    }

    @Override
    public int getCount() {
        return cart.values().stream().mapToInt(Product::getQty).sum();
    }

    @Override
    public double getAmount() {
        return cart.values().stream().mapToDouble(product -> product.getDiscountprice() * product.getQty()).sum();
    }
}
