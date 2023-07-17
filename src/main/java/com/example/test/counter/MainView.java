package com.example.test.counter;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("main")
public class MainView extends VerticalLayout {
    private final CounterService counterService;

    private TextField counterField;


    @Autowired
    public MainView(CounterService counterService) {
        this.counterService = counterService;

        counterField = new TextField("Counter");
        counterField.setValue(String.valueOf(counterService.getCounterValue()));

        Button incrementButton = new Button("Increment");

        incrementButton.addClickListener(e -> {
            counterService.incrementCounter();
            counterField.setValue(String.valueOf(counterService.getCounterValue()) );
        });

        counterField.addValueChangeListener(e -> {
            counterService.setCounterValue(Integer.parseInt(e.getValue()));
        });

        add(counterField, incrementButton);

    }





}
