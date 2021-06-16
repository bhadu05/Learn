package com.ex.demo3.history;

import javax.persistence.*;

@Entity
@Table
public class count {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column
        int id;
        String type;
        int count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
