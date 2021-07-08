package cloud.carles.amuleplex.application.services.search;

import cloud.carles.amuleplex.application.dto.search.SearchRequestDTO;
import cloud.carles.amuleplex.application.services.amulecmd.AmuleCommandApi;
import cloud.carles.amuleplex.application.services.amulecmd.command.SearchCommand;
import cloud.carles.amuleplex.application.services.amulecmd.exception.AmuleCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchProcessor {
    @Autowired
    private AmuleCommandApi api;

    public void process(SearchRequestDTO search) throws AmuleCommandException {
        this.api.send(new SearchCommand(search.getQuery()));
    }
}
