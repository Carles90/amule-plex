package cloud.carles.amuleplex.application.services.search;

import cloud.carles.amuleplex.application.dto.search.SearchResultDTO;
import cloud.carles.amuleplex.application.services.amulecmd.AmuleCommandApi;
import cloud.carles.amuleplex.application.services.amulecmd.command.ResultsCommand;
import cloud.carles.amuleplex.application.services.amulecmd.exception.AmuleCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsProvider {
    @Autowired
    private AmuleCommandApi api;
    @Autowired
    private ResultsMapper mapper;
    @Autowired
    private ResultsFilterer filterer;
    @Autowired
    private ResultsOrderer orderer;

    public List<SearchResultDTO> provide() throws AmuleCommandException {
        String[] lines = api.send(new ResultsCommand());
        return orderer.order(filterer.filter(mapper.map(lines)));
    }
}
