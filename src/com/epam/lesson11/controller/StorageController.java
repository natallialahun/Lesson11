package com.epam.lesson11.controller;

import com.epam.lesson11.exception.StorageInitException;
import com.epam.lesson11.exception.StorageSaveException;
import com.epam.lesson11.model.Product;
import com.epam.lesson11.model.Storage;
import com.epam.lesson11.view.StorageView;

import java.io.*;

/**
 * Created by Natallia_Lahun on 03/28/2017.
 */
public class StorageController {

    private Storage model;
    private StorageView view;
    private String fileName;

    public StorageController(Storage model, StorageView view){
        this.model = model;
        this.view = view;
    }

    public void addProduct(Product product){
          model.add(product);
    }

    public void deleteProductByID(int productID){
        model.deleteById(productID);
    }

    public void delete(Product product){
        model.delete(product);
    }

    public boolean contains(Product product){
        return model.contains(product);
    }


    public void save(String fileName) throws StorageSaveException {
        try {
            File file = new File(fileName);
            ObjectOutputStream objectWriter = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            objectWriter.writeObject(model);
            objectWriter.close();
        } catch (Exception e) {
            throw new StorageSaveException();
        }
    }


    public void init(String fileName) throws StorageInitException {
        try {
            File file = new File(fileName);
            if (!file.exists())
            {
                file.createNewFile();
            } else {
                if (file.length()>0) {
                    ObjectInputStream objectReader = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                    model =((Storage) objectReader.readObject());
                }
            }
        } catch (IOException | ClassNotFoundException e){
            throw new StorageInitException();
        }
    }

    public void print(){
        view.printStorage(model);
    }

    public int getNextID(){
        return model.getNextID();
    }

    public Product findById(int id){
        return model.findByID(id);
    }

}
