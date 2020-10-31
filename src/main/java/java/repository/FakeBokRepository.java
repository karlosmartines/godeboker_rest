package java.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import domain.Bestilling;
import domain.Bok;

@Repository
public class FakeBokRepository {
    private Map<Bok, Integer> boker;
    private List<Bestilling> bestillinger;

    public FakeBokRepository() {
        this.boker = new HashMap<>();
        boker.put(new Bok("God bok 1", 1234567, 199), 500);
        boker.put(new Bok("God bok 2", 1234568, 299), 500);
        boker.put(new Bok("God bok 3", 1234569, 249), 500);
        boker.put(new Bok("God bok 4", 1234577, 149), 500);
        boker.put(new Bok("God bok 5", 1234578, 99), 89);
    }
    public boolean bokPaLager(Integer isbn){
        return 0 < finnBokMedIsbn(isbn)
            .getAntall();
    }

    public Bok finnBokMedIsbn(int isbn){
        return boker.keySet().stream()
            .filter(b -> b.getIsbn().equals(isbn))
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
    }

    public Map<Map<Bok, Integer>, Set<Integer>> lagBestilling(Map<Integer, Integer> bestilling){
        Map<Bok, Integer> bestillingMap = new HashMap<>();

        bestilling.keySet().stream()
            .filter(this::bokPaLager)
            .forEach(b -> bestillingMap.put(finnBokMedIsbn(b), bestilling.get(b)));

        Set<Integer> manglendeBoker = bestilling.keySet().stream()
            .filter(b -> !bokPaLager(b))
            .collect(Collectors.toSet());

        Map<Map<Bok, Integer>, Set<Integer>> bestillingsResultat = new HashMap<>();
        bestillingsResultat.put(bestillingMap, manglendeBoker);

        return bestillingsResultat;
    }




}