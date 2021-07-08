package cloud.carles.amuleplex.application.services.search;

import cloud.carles.amuleplex.application.dto.search.SearchResultDTO;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultsOrderer {
    public List<SearchResultDTO> order(List<SearchResultDTO> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(SearchResultDTO::getSources).reversed())
                .collect(Collectors.toList());
    }
}
