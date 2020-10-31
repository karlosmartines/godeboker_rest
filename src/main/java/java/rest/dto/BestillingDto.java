package java.rest.dto;

import java.util.HashMap;
import java.util.Map;

import domain.Bok;

public class BestillingDto {
    private Map<Integer, Integer> bestillingMap;
    private int pris;

    public BestillingDto() {
        boker = new HashMap<>();
    }

    public BetsillingDto(Map<>)

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public Map<Integer, Integer> getBestillingMap() {
        return bestillingMap;
    }
}
