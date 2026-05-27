package org.example;

import java.io.Serializable;

public class Student implements Serializable {
    public String publicId;
    private String name;
    private int age;

    public Student() {
        this.name = "Necunoscut";
        this.age = 0;
    }

    public Student(String name) {
        this.name = name;
        this.age = 18;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello! Eu sunt " + name + " și am " + age + " ani.");
    }

    private void secretMethod() {
        System.out.println("Aceasta este o metodă privată apelată prin Reflection!");
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}
