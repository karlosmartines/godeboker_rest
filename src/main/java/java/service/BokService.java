package java.service;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import domain.Bok;
import repository.FakeBokRepository;
import rest.dto.BestillingDto;

public class BokService {
    @Autowired
    private FakeBokRepository bokRepository;

    public BestillingDto bestill(BestillingDto bestillingDto){
        Map<Integer, Integer> bestillingMap = bestillingDto.getBestillingMap();

        Map<Map<Bok, Integer>, Set<Integer>> bestillingsResultat
            = bokRepository.lagBestilling(bestillingMap);

        Map<Bok, Integer> bestilteBoker = bestillingsResultat.keySet().stream().findFirst().get();

        Set<Integer> ikkeBestilteBoker = bestillingsResultat.values().stream().

        BestillingDto  = new BestillingDto(bestilteBoker);

        if(bestilteBoker.size() > 0){
            int bestillingPris = bestilteBoker.keySet().stream()
                .mapToInt(b -> b.getPris() * bestilteBoker.get(b))
                .sum();
        } else{
            throw new NoSuchElementException("None of the wanted book are available.");
        }
        return new BestillingDto()
    }

}
