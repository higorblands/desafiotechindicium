package com.techindicium.desafiotechindicium.service;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.domain.CategoriesMongoList;
import com.techindicium.desafiotechindicium.domain.OrdersMongoList;
import com.techindicium.desafiotechindicium.models.*;
import com.techindicium.desafiotechindicium.repository.*;
import com.techindicium.desafiotechindicium.usecase.*;
import com.techindicium.desafiotechindicium.usecase.impl.*;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
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
    @Autowired
    OrdersMongoRepository ordersMongoRepository;
    @Autowired
    CategoriesMongoRepository categoriesMongoRepository;

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
        logger.info(".:: Bem vindo ao programa ::.");
        logger.info("Deseja iniciar conversão Db e CSV para arquivo local ? Y ou N");
        Scanner myAnswerDbToJson = new Scanner(System.in);
        String resultMyAnswerDbToJson = myAnswerDbToJson.nextLine().toUpperCase(Locale.ROOT);

        while (resultMyAnswerDbToJson.equals("Y")) {
            logger.info("Quer utilizar a data atual do sistema ? Y ou N ");
            Scanner resultMyAnswerUseSystemDate = new Scanner(System.in);
            String resulMyAnswerUseSystemDate = resultMyAnswerUseSystemDate.nextLine().toUpperCase(Locale.ROOT);

            if (resulMyAnswerUseSystemDate.equals("Y")) {
                LocalDate date = LocalDate.now();
                String localDate = String.valueOf(date);
                generateDbToJsonFile(localDate);
            } else if (resulMyAnswerUseSystemDate.equals("N")) {
                LocalDate date = LocalDate.now();
                String localDate = String.valueOf(date);
                logger.info("Digite a data que quer utilizar com formato por exemplo : " + localDate);
                Scanner myDate = new Scanner(System.in);
                String resultDateInput = myDate.nextLine();
                generateDbToJsonFile(resultDateInput);
            }
            logger.info("O resultado da consulta no Mongo está de modo automático ao finalizar o programa.");
            logger.info("Deseja converter de Json arquivo local para MongoDB ? Y ou N ");
            Scanner resultMyAnswerJsonToMongoDBS = new Scanner(System.in);
            String resultMyAnswerJsonToMongoDB = resultMyAnswerJsonToMongoDBS.nextLine().toUpperCase(Locale.ROOT);
            if (resultMyAnswerJsonToMongoDB.equals("Y")) {
                LocalDate date = LocalDate.now();
                String localDate = String.valueOf(date);
                convertToMongoDB(localDate);
            }
            logger.info("Voltando pro inicio ! ");
            logger.info("Deseja converter Db e CSV para uma nova Db ? Y ou N : ");
            Scanner myAnswerContinue = new Scanner(System.in);
            resultMyAnswerDbToJson = myAnswerContinue.nextLine().toUpperCase(Locale.ROOT);
        }
        resultadoMongoDB();
        logger.info(" #### Resultado do Mongo gerado com sucesso na pasta mongoResult ! ####");
        logger.info("Programa finalizado, obrigado !");
    }

    @SneakyThrows
    private void resultadoMongoDB() {
        String toFile = String.valueOf(ordersMongoRepository.findAll());
        Files.writeString(Paths.get("mongoResult\\ordersMongo.log"), toFile);
    }

    private void convertToMongoDB(String localDate) {
        generateJsonFileToMongo(localDate);

    }

    @SneakyThrows
    private void generateJsonFileToMongo(String localDate) {
        String jsonCategories
                = String.join(" ",
                Files.readAllLines(
                        Paths.get("data\\postgres-" + localDate + "-categories.json"),
                        StandardCharsets.UTF_8)
        );
        CategoriesMongoList categoriesMongoList = new Gson().fromJson(jsonCategories, CategoriesMongoList.class);
        categoriesMongoList.getCategories().forEach(categoriesMongo -> categoriesMongoRepository.save(categoriesMongo));

        String jsonOrders
                = String.join(" ",
                Files.readAllLines(
                        Paths.get("data\\postgres-" + localDate + "-orders.json"),
                        StandardCharsets.UTF_8)
        );
        OrdersMongoList ordersMongoList = new Gson().fromJson(jsonOrders, OrdersMongoList.class);
        ordersMongoList.getOrders().forEach(ordersMongo -> ordersMongoRepository.save(ordersMongo));
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

        generateJsonFileFromCsvFile.execute(localDate);
    }
}
