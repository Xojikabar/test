package com.example.test.counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private final CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public int getCounterValue() {
        return counterRepository.findById(1L).map(Counter::getValue).orElse(0);
    }

    public void incrementCounter() {
        Counter counter = counterRepository.findById(1L).orElse(new Counter());
        counter.increment();
        counterRepository.save(counter);
    }

    public void setCounterValue(int value) {
        Counter counter = counterRepository.findById(1L).orElse(new Counter());
        counter.setValue(value);
        counterRepository.save(counter);
    }
}

