package com.rgretail.grocermax.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhishek on 10/3/2015.
 */
public class CategoriesProducts extends BaseResponseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    String category_id;
    String category_name;
    int Totalcount;

    @Expose
    private List<Product> product = new ArrayList<Product>();

    public List<Product> getItems() {
        return product;
    }

    public void setItems(List<Product> items) {
        this.product = items;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getTotalCount(){return Totalcount;}

    public void setTotalCount(int totalcount){
        this.Totalcount = totalcount;
    }


}
