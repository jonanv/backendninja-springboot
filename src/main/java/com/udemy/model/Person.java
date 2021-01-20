package com.udemy.model;

// import javax.validation.constraints.Min;
// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Size;

// TODO: No se puede hacer validacion con el javax para el formulario
public class Person {
    // @NotNull
    // @Size(min=2, max=6)
    private String name;
    
    // @NotNull
    // @Min(18)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
