package com.example.demoapplication.processing;

import com.example.demoapplication.model.Client;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

@Component
@Scope("prototype")
public class ClientCoffee {
    Client client = new Client("Ivan");
    Class clazz = client.getClass();
    Scanner scanner = new Scanner(System.in);
    Collection milkList = new ArrayList();
    Collection coffeeList = new ArrayList();

    String choiceCoffee = "Выберите нужный вид кофе: 1) Эспрессо, 2) Латте, 3) Капучино, 4) Американо";
    String milk = "Выберите тип молока, который вы ходите добавить в кофе: 1) драконье,  2) коровье, 3) собачье, 4) грудное, 5) банановое, 6) кокосовое";

    public void order(Object o) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.addAll(milkList, "драконьем", "коровьем", "собачьем", "грудноем", "банановоем", "кокосовоем");
        Collections.addAll(coffeeList, "Эспрессо", "Латте", "Капучино", "Американо");

        System.out.println(choiceCoffee);
        Integer inputCoffee = scanner.nextInt();
        if (inputCoffee == 1) {
            System.out.println("Вы заказали: " + coffeeList.toArray()[0]);
        } if (inputCoffee == 2) {
            System.out.println("Вы заказали: " + coffeeList.toArray()[1]);
        } if (inputCoffee == 3) {
            System.out.println("Вы заказали: " + coffeeList.toArray()[2]);
        } if (inputCoffee == 4) {
            System.out.println("Вы заказали: " + coffeeList.toArray()[3]);
        }

        System.out.println(milk);
        Integer inputMilk = scanner.nextInt();
        if (inputMilk == 1) {
            System.out.println("На " + milkList.toArray()[0] + " молоке");
        } if (inputMilk == 2) {
            System.out.println("На " + milkList.toArray()[1] + " молоке");
        } if (inputMilk == 3) {
            System.out.println("На " + milkList.toArray()[2] + " молоке");
        } if (inputMilk == 4) {
            System.out.println("На " + milkList.toArray()[3] + " молоке");
        } if (inputMilk == 5) {
            System.out.println("На " + milkList.toArray()[4] + " молоке");
        } if (inputMilk == 6) {
            System.out.println("На " + milkList.toArray()[5] + " молоке");
        }

        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "String":
                    String name = (String) i.get(o);
                    stringBuilder.append(name).append(" заказ принят, ваш номер ");
                    break;
                case "Integer":
                    Integer num = (Integer) i.get(o);
                    stringBuilder.append(num);
                    break;
            }
        }
        System.out.println(stringBuilder.toString().substring(0, stringBuilder.length()));
    }
}