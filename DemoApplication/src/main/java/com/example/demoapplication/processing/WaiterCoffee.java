package com.example.demoapplication.processing;

import com.example.demoapplication.model.Staff;
import com.example.demoapplication.model.Working;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Scope
@Component
public class WaiterCoffee implements Working {
    Staff staff = new Staff("Anna", "Официант", 800.0);

//  Стоит для демонстрации функционала
    @PostConstruct
    public void infoWaiter() throws IllegalAccessException {

        Class clazz = staff.getClass();
        StringBuilder stringBuilder = new StringBuilder();
        
        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getName()) {
                case "name":
                    String name = (String) i.get(staff);
                    stringBuilder.append(name).append(" ");
                    break;
                case "post":
                    String post = (String) i.get(staff);
                    stringBuilder.append(post).append(" ");
                    break;
                case "salary":
                    Double salary = (Double) i.get(staff);
                    stringBuilder.append(Double.valueOf(salary)).append(" ");
                    break;
            }
        }
        System.out.println(stringBuilder.toString().substring(0, stringBuilder.length()));
    }

    @Override
    public void work() {
        System.out.println("Официант несет ваш заказ");
    }
}