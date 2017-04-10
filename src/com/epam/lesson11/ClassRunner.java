package com.epam.lesson11;


import com.epam.lesson11.controller.StorageController;
import com.epam.lesson11.exception.StorageInitException;
import com.epam.lesson11.exception.StorageSaveException;
import com.epam.lesson11.model.Product;
import com.epam.lesson11.model.Storage;
import com.epam.lesson11.view.StorageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



/**
 * Created by Natallia_Lahun on 03/28/2017.
 */
public class ClassRunner {


    public static void main(String[] args) {

        int userChoice;
        StorageView storageView = new StorageView();
        Storage storage = new Storage();
        StorageController sc = new StorageController(storage, storageView);
        String fileName = "files\\storage.bin";
        try {
            sc.init(fileName);
        } catch(StorageInitException e){
            e.printStackTrace();
        }
        while((userChoice = menu())<7){
            switch (userChoice) {
                case 1:
                    Product product = addProduct(sc.getNextID());
                    sc.addProduct(product);
                    break;
                case 2:
                    sc.deleteProductByID(getProductID());
                    break;
                case 3:
                    sc.print();
                    break;
                case 4:
                    System.out.println(sc.findById(getProductID()));
                    break;
                case 5:
                    try {
                        sc.init(fileName);
                    } catch(StorageInitException e){
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        sc.save(fileName);
                    } catch (StorageSaveException e){
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    break;
                default:
                    // The user input an unexpected choice.
            }
        }
        try {
            sc.save(fileName);
        } catch (StorageSaveException e){
            e.printStackTrace();
        }
    }

    public static int menu() {
        Scanner input = new Scanner(System.in);

        int selection;

        /***************************************************/

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Add new Product");
        System.out.println("2 - Delete product by ID");
        System.out.println("3 - Print all Products in Storage");
        System.out.println("4 - Find Product By ID");
        System.out.println("5 - Reload storage");
        System.out.println("6 - Save storage");
        System.out.println("7 - Quit");

        selection = input.nextInt();
        return selection;
    }

    public static Product addProduct(int id){
        Scanner input = new Scanner(System.in);
        String dateFormat = "dd/MM/yyyy";
        System.out.println("Enter product name: ");
        String productName = input.nextLine();
        System.out.println("Enter product category: ");
        String productCategory = input.nextLine();
        System.out.println("Enter producer code: ");
        String producerCode = input.nextLine();
        System.out.println("Enter production date: ");
        Date productionDate = null;
        while(productionDate == null) {
            try {
                productionDate = new SimpleDateFormat(dateFormat).parse(input.nextLine());
            } catch (ParseException e) {
                System.out.println("Wrong date format. The format should be like dd/MM/yyyy");
            }
        }
        System.out.println("Enter product description: ");
        String productDescription = input.nextLine();
        return new Product(id, productName, productCategory, producerCode, productionDate, productDescription );
    }

    public static int getProductID(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter product id: ");
        return input.nextInt();
    }

}
