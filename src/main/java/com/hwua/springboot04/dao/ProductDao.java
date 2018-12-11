package com.hwua.springboot04.dao;

import com.hwua.springboot04.po.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {
    private static List<Product> products = new ArrayList<>();

    private static int productId = 1000;

    static {
        Product p1 = new Product(productId++,"Apple iPhone XS (A2100) 64GB 金色 移动联通电信4G手机","https://img13.360buyimg.com/n1/s450x450_jfs/t1/1468/11/3377/138213/5b997bf3Eda5b24a4/0ace3ed19582dbe6.jpg",8699.0,100);
        Product p2 = new Product(productId++,"Apple iPhone XXS (A2100) 64GB 金色 移动联通电信4G手机","https://img13.360buyimg.com/n1/s450x450_jfs/t1/1468/11/3377/138213/5b997bf3Eda5b24a4/0ace3ed19582dbe6.jpg",8699.0,100);
        Product p3 = new Product(productId++,"Apple iPhone XXXS (A2100) 64GB 金色 移动联通电信4G手机","https://img13.360buyimg.com/n1/s450x450_jfs/t1/1468/11/3377/138213/5b997bf3Eda5b24a4/0ace3ed19582dbe6.jpg",8699.0,100);
        Product p4 = new Product(productId++,"Apple iPhone XXXXS (A2100) 64GB 金色 移动联通电信4G手机","https://img13.360buyimg.com/n1/s450x450_jfs/t1/1468/11/3377/138213/5b997bf3Eda5b24a4/0ace3ed19582dbe6.jpg",8699.0,100);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
    }

    /**
     * 获取所有商品
     * @return
     */
    public List<Product> getAll(){
        return products;
    }

    /**
     * 根据id获取指定商品
     * @param productId 商品id
     * @return
     */
    public Product get(Integer productId){
        for (Product p: products) {
            if (p.getId().equals(productId)){
                return p;
            }
        }
        return null;
    }

    /**
     * 添加商品
     * @param product
     * @return
     */
    public boolean save(Product product){
        product.setId(productId++);
        return products.add(product);
    }

    /**
     * 修改商品信息
     * @param product
     * @return
     */
    public Product update(Product product){
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getId().equals(product.getId())){
                return products.set(i,product);
            }
        }
        return null;
    }

    /**
     * 根据id删除商品
     * @param productId 商品的id
     * @return
     */
    public Product delete(Integer productId){
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getId().equals(productId)){
                return products.remove(i);
            }
        }
        return null;
    }
}
