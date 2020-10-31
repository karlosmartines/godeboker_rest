package java.domain;

import java.util.List;
import java.util.Map;

public class Bestilling {
    private Map<Bok, Integer> boker;
    private Integer sum;

    public Bestilling(List<Bok> boker, Integer sum) {
        this.boker = boker;
        this.sum = sum;
    }

    //public void leggTilBok(Integer isbn, int antall){
    //    if(boker.containsKey(isbn)){
    //        boker.put(isbn, boker.get(isbn) + antall);
    //    } else{
    //        boker.put(isbn, antall);
    //    }
    //}
}
