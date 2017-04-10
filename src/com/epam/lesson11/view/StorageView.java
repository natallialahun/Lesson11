package com.epam.lesson11.view;


import com.epam.lesson11.model.Product;
import com.epam.lesson11.model.Storage;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Natallia_Lahun on 03/28/2017.
 */
public class StorageView {

    public void printStorage(Storage storage){
        for (Product product: storage) {
            System.out.println(product);

        }
    }

}
