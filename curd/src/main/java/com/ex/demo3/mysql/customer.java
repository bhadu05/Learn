package com.ex.demo3.mysql;


import javax.persistence.*;

@Entity
@Table
public class customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }
}
