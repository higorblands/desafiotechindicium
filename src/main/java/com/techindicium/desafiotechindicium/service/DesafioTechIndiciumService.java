package com.techindicium.desafiotechindicium.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.techindicium.desafiotechindicium.models.Categories;
import com.techindicium.desafiotechindicium.models.Customer_Customer_Demo;
import com.techindicium.desafiotechindicium.models.Orders;
import com.techindicium.desafiotechindicium.repository.CategoriesRepository;
import com.techindicium.desafiotechindicium.repository.Customer_Customer_DemoRepository;
import com.techindicium.desafiotechindicium.repository.OrdersRepository;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileCategories;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileCustomer_Customer_Demo;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileOrders;
import com.techindicium.desafiotechindicium.usecase.impl.GenerateJsonFileCategoriesImpl;
import com.techindicium.desafiotechindicium.usecase.impl.GenerateJsonFileCustomer_customer_demoImpl;
import com.techindicium.desafiotechindicium.usecase.impl.GenerateJsonFileOrdersImpl;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class DesafioTechIndiciumService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DesafioTechIndiciumService.class);
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    Customer_Customer_DemoRepository customer_customer_demoRepository;

    GenerateJsonFileCategories generateJsonFileCategories = new GenerateJsonFileCategoriesImpl();
    GenerateJsonFileOrders generateJsonFileOrders = new GenerateJsonFileOrdersImpl();
    GenerateJsonFileCustomer_Customer_Demo generateJsonFileCustomer_customer_demo = new GenerateJsonFileCustomer_customer_demoImpl();

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


        List<Orders> ordersList = ordersRepository.findAll();
        generateJsonFileOrders.execute(ordersList, localDate);

        List<Customer_Customer_Demo> customer_customer_demoList = customer_customer_demoRepository.findAll();
        generateJsonFileCustomer_customer_demo.execute(customer_customer_demoList, localDate);

        generateCsvToJsonFile(localDate);


    }

    @SneakyThrows
    private void generateCsvToJsonFile(String localDate) {
        CsvMapper csvMapper = new CsvMapper();
        ObjectMapper mapper = new ObjectMapper();

        File input = new File("data\\order_details.csv");
        File output = new File("data\\csv-" + localDate + "-order_details.json");

        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
    }
}
