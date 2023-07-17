package com.example.test.counter;

import jakarta.persistence.*;


@Entity(name = "counter")
public class Counter {
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "Sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seq")
    private Integer id;

    @Column(name = "counter_value")
    private int value;

    public Counter() {
    }

    public Integer getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }
}
