package cloud.carles.amuleplex.application.services.search;

import cloud.carles.amuleplex.application.dto.search.SearchResultDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ResultsMapper {
    public List<SearchResultDTO> map(String[] lines) {
        Pattern pattern = Pattern.compile("(\\d+)\\.\\s+(\\S+(?:\\s\\S+)*)\\s+(\\d*\\.?\\d*)\\s+(\\d*)");

        return Arrays.stream(lines)
                .filter(Objects::nonNull)
                .map(line -> {
                    Matcher matcher = pattern.matcher(line);

                    if (!matcher.find()) {
                        return null;
                    }

                    return matcher;
                })
                .filter(Objects::nonNull)
                .map(matcher -> new SearchResultDTO(
                        Integer.parseInt(matcher.group(1)),
                        matcher.group(2),
                        Float.parseFloat(matcher.group(3)),
                        Integer.parseInt(matcher.group(4))
                ))
                .collect(Collectors.toList());
    }
}
