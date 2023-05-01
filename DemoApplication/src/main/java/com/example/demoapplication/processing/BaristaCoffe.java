package com.example.demoapplication.processing;

import com.example.demoapplication.model.Staff;
import com.example.demoapplication.model.Working;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Scope
public class BaristaCoffe implements Working {

    public Staff staff = new Staff("Ivan", "Бариста", 1000.0);

    @PreDestroy
    public void infoBarista() throws IllegalAccessException {

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
        System.out.println("Бариста работает");
    }
}