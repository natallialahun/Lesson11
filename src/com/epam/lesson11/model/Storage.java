package com.epam.lesson11.model;

import com.epam.lesson11.exception.StorageInitException;
import com.epam.lesson11.exception.StorageSaveException;

import java.io.*;
import java.util.*;

/**
 * Created by Natallia_Lahun on 03/28/2017.
 */
public class Storage implements Serializable, Iterable<Product> {

    private List<Product> storage = new ArrayList<Product>();
    private Integer currentID = 0;



    private static final Long serialVersionUID = 1L;

    public void add(Product product) {
        storage.add(product);
        currentID++;
    }


    public void delete(Product product) {
        storage.remove(product.getProductID());
    }

    public void deleteById(int id) {
        storage.remove(id);
    }

    public boolean contains(Product product) {
        return storage.contains(product);
    }

    public Product findByID(Integer id) {
        if (id >= storage.size()){
            return null;
        }
            return storage.get(id);
    }

    public int getNextID() {
        return currentID;
    }

    public Iterator<Product> iterator(){
        return new MySetIterator();
    }

    private class MySetIterator implements
            Iterator<Product> {
        private Product cursor;
        private int idx;

        public MySetIterator() {
            this.idx = 0;
        }

        public boolean hasNext() {
            return storage.size() > 0 && this.idx < storage.size() ;
        }

        public Product next() {
            if(this.hasNext()) {
                Product current = storage.get(idx);;
                this.idx ++;
                return current;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }




}