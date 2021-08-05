package com.techindicium.desafiotechindicium.service;

import com.mongodb.client.*;
import com.techindicium.desafiotechindicium.models.*;
import com.techindicium.desafiotechindicium.repository.*;
import com.techindicium.desafiotechindicium.usecase.*;
import com.techindicium.desafiotechindicium.usecase.impl.*;
import lombok.SneakyThrows;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Component
public class DesafioTechIndiciumService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DesafioTechIndiciumService.class);

    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    Customer_Customer_DemoRepository customer_customer_demoRepository;
    @Autowired
    Customer_DemographicsRepository customer_demographicsRepository;
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    Employee_TerritoriesRepository employee_territoriesRepository;
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    ShippersRepository shippersRepository;
    @Autowired
    SuppliersRepository suppliersRepository;
    @Autowired
    TerritoriesRepository territoriesRepository;
    @Autowired
    Us_StatesRepository us_statesRepository;

    GenerateJsonFileCategories generateJsonFileCategories = new GenerateJsonFileCategoriesImpl();
    GenerateJsonFileCustomer_Customer_Demo generateJsonFileCustomer_customer_demo = new GenerateJsonFileCustomer_customer_demoImpl();
    GenerateJsonFileCustomer_Demographics generateJsonFileCustomer_demographics = new GenerateJsonFileCustomer_demographicsImpl();
    GenerateJsonFileCustomers generateJsonFileCustomers = new GenerateJsonFileCustomersImpl();
    GenerateJsonFileEmployee_Territories generateJsonFileEmployee_territories = new GenerateJsonFileEmployee_TerritoriesImpl();
    GenerateJsonFileEmployees generateJsonFileEmployees = new GenerateJsonFileEmployeesImpl();
    GenerateJsonFileOrders generateJsonFileOrders = new GenerateJsonFileOrdersImpl();
    GenerateJsonFileProducts generateJsonFileProducts = new GenerateJsonFileProductsImpl();
    GenerateJsonFileRegion generateJsonFileRegion = new GenerateJsonFileRegionImpl();
    GenerateJsonFileShippers generateJsonFileShippers = new GenerateJsonFileShippersImpl();
    GenerateJsonFileSuppliers generateJsonFileSuppliers = new GenerateJsonFileSuppliersImpl();
    GenerateJsonFileTerritories generateJsonFileTerritories = new GenerateJsonFileTerritoriesImpl();
    GenerateJsonFileUs_States generateJsonFileUs_states = new GenerateJsonFileUs_StatesImpl();
    GenerateJsonFileFromCsvFile generateJsonFileFromCsvFile = new GenerateJsonFileFromCsvFileImpl();

    @SneakyThrows
    public void run(String... args) {

        logger.info("Deseja converter Db e CSV para uma nova Db ? y ou n : ");
        Scanner myObjStartProgram = new Scanner(System.in);
        String resultInputStartProgram = myObjStartProgram.nextLine();
        while (resultInputStartProgram.equals("y")) {

            logger.info("Deseja fazer a conversão com a data atual do sistema ? y ou n : ");
            Scanner myObj = new Scanner(System.in);
            String resultInput = myObj.nextLine();

            if (resultInput.equals("y")) {
                LocalDate date = LocalDate.now();
                String localDate = String.valueOf(date);

                generateDbToJsonFile(localDate);

            } else if (resultInput.equals("n")) {
                LocalDate date = LocalDate.now();
                String localDate = String.valueOf(date);

                logger.info("Digite a data que quer utilizar com formato por exemplo : " + localDate);
                Scanner myDate = new Scanner(System.in);
                String resultDateInput = myDate.nextLine();

                generateDbToJsonFile(resultDateInput);
            } else {
                logger.info("Opção inválida ! ");
            }
            logger.info("Deseja converter Db e CSV para uma nova Db ? y ou n : ");
            myObjStartProgram = new Scanner(System.in);
            resultInputStartProgram = myObjStartProgram.nextLine();
        }


        logger.info("Programa finalizado ! ");

    }

    @SneakyThrows
    private void generateDbToJsonFile(String localDate) {


        List<Categories> categoriesList = categoriesRepository.findAll();
        generateJsonFileCategories.execute(categoriesList, localDate);

        List<Customer_Customer_Demo> customer_customer_demoList = customer_customer_demoRepository.findAll();
        generateJsonFileCustomer_customer_demo.execute(customer_customer_demoList, localDate);

        List<Customer_Demographics> customer_demographicsList = customer_demographicsRepository.findAll();
        generateJsonFileCustomer_demographics.execute(customer_demographicsList, localDate);

        List<Customers> customersList = customersRepository.findAll();
        generateJsonFileCustomers.execute(customersList, localDate);

        List<Employee_Territories> employee_territoriesList = employee_territoriesRepository.findAll();
        generateJsonFileEmployee_territories.execute(employee_territoriesList, localDate);

        List<Employees> employeesList = employeesRepository.findAll();
        generateJsonFileEmployees.execute(employeesList, localDate);

        List<Orders> ordersList = ordersRepository.findAll();
        generateJsonFileOrders.execute(ordersList, localDate);

        generateJsonFileFromCsvFile.execute(localDate);

        List<Products> productsList = productsRepository.findAll();
        generateJsonFileProducts.execute(productsList, localDate);

        List<Region> regionList = regionRepository.findAll();
        generateJsonFileRegion.execute(regionList, localDate);

        List<Shippers> shippersList = shippersRepository.findAll();
        generateJsonFileShippers.execute(shippersList, localDate);

        List<Suppliers> suppliersList = suppliersRepository.findAll();
        generateJsonFileSuppliers.execute(suppliersList, localDate);

        List<Territories> territoriesList = territoriesRepository.findAll();
        generateJsonFileTerritories.execute(territoriesList, localDate);

        List<Us_States> us_statesList = us_statesRepository.findAll();
        generateJsonFileUs_states.execute(us_statesList, localDate);

        String file = ("data\\csv-" + localDate + "-order_details.json");
        String json = readFileAsString(file);


        MongoClient client = MongoClients.create("mongodb://northwind_user:thewindisblowing@0.0.0.0:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false");
        MongoDatabase database = client.getDatabase("myMongoDB");
        MongoCollection<Document> dbCollection = database.getCollection("orders");
        FindIterable<Document> dbCursor = dbCollection.find();
        Iterator it = dbCursor.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("Database Connected");

    }

    @SneakyThrows
    private String readFileAsString(String file) {
        return new String(Files.readAllBytes(Paths.get(file)));
    }


}
