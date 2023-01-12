package com.matthes.springdemo.hotdog;

import com.matthes.springdemo.hotdog.ingrediants.Bread;
import com.matthes.springdemo.hotdog.ingrediants.Mustard;
import com.matthes.springdemo.hotdog.ingrediants.Sausage;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Hotdog {
    private Bread bread;
    private Sausage sausage;

    private Mustard mustard;

    public Hotdog(Bread bread, Sausage sausage, Mustard mustard) {
        this.bread = bread;
        this.sausage = sausage;
        this.mustard = mustard;
    }

    public Bread getBread() {
        return bread;
    }

    public Sausage getSausage() {
        return sausage;
    }

    public Mustard getMustard() {
        return mustard;
    }
}
