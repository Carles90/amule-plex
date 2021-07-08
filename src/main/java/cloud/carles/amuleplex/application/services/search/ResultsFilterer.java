package cloud.carles.amuleplex.application.services.search;

import cloud.carles.amuleplex.application.dto.search.SearchResultDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultsFilterer {
    public List<SearchResultDTO> filter(List<SearchResultDTO> list) {
        return list.stream()
                .filter(i -> i.getSize() > 100)
                .collect(Collectors.toList());
    }
}
