package com.example.demoapplication;

import com.example.demoapplication.model.Client;
import com.example.demoapplication.processing.BaristaCoffe;
import com.example.demoapplication.processing.ClientCoffee;
import com.example.demoapplication.processing.WaiterCoffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Cafe {
    Client client = new Client("Ivan");
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public ClientCoffee clientCoffee;
    @Autowired
    public BaristaCoffe baristaCoffe;
    @Autowired
    public WaiterCoffee waiterCoffee;

    public void process() throws IllegalAccessException {
        System.out.println("Сделать заказ: 3\n" +
                "Информация о персонате: 1) Бариста, 2) Официант");
        Integer input = scanner.nextInt();
        if (input == 1){
            baristaCoffe.infoBarista();
            System.exit(1);
        } if (input == 2) {
            waiterCoffee.infoWaiter();
            System.exit(2);
        } else {
            clientCoffee.order(client);
            baristaCoffe.work();
            waiterCoffee.work();
        }
    }
}