package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.dto.download.DownloadListItemDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class DownloadListMapper {
    public List<DownloadListItemDTO> map(String[] lines) {
        List<String> dlLines = Arrays.stream(lines)
                .filter(Objects::nonNull)
                .filter(line -> line.startsWith(" > "))
                .map(line -> line.substring(3))
                .collect(Collectors.toList());

        Pattern firstLinePattern = Pattern.compile("(\\w*)\\s+(.*)");
        Pattern secondLinePattern = Pattern.compile(".*\\[(.*)\\%\\]\\s*(\\d*)\\/\\s+(\\d*).+\\s\\((\\d*)\\)\\s\\-\\s(.*)\\s\\-\\s(.*)\\s\\-\\s(.*)\\s\\-\\s(.*)");
        Pattern secondLinePatternOption2 = Pattern.compile(".*\\[(.*)\\%\\]\\s*(\\d*)\\/\\s+(\\d*).+\\s\\-\\s(.*)\\s\\-\\s(.*)\\s\\-\\s(.*)");

        List<DownloadListItemDTO> result = new ArrayList<>();

        for (int i = 0; i < dlLines.size(); i += 2) {
            String firstLine = dlLines.get(i);
            String secondLine = dlLines.get(i + 1);

            Matcher firstLineMatcher = firstLinePattern.matcher(firstLine);
            Matcher secondLineMatcher = secondLinePattern.matcher(secondLine);

            firstLineMatcher.find();
            secondLineMatcher.find();

            try {
                result.add(new DownloadListItemDTO(
                        firstLineMatcher.group(1),
                        firstLineMatcher.group(2),
                        Float.parseFloat(secondLineMatcher.group(1)),
                        Integer.parseInt(secondLineMatcher.group(4)),
                        Integer.parseInt(secondLineMatcher.group(2)),
                        Integer.parseInt(secondLineMatcher.group(3)),
                        secondLineMatcher.group(4),
                        secondLineMatcher.group(5),
                        secondLineMatcher.group(6),
                        secondLineMatcher.group(7)
                ));
            } catch (IllegalStateException e) {
                Matcher secondLineMatcherOption2 = secondLinePatternOption2.matcher(secondLine);
                secondLineMatcherOption2.find();

                result.add(new DownloadListItemDTO(
                        firstLineMatcher.group(1),
                        firstLineMatcher.group(2),
                        Float.parseFloat(secondLineMatcherOption2.group(1)),
                        0,
                        Integer.parseInt(secondLineMatcherOption2.group(2)),
                        Integer.parseInt(secondLineMatcherOption2.group(3)),
                        secondLineMatcherOption2.group(4),
                        secondLineMatcherOption2.group(5),
                        secondLineMatcherOption2.group(6),
                        ""
                ));
            }
        }

        return result;
    }
}
