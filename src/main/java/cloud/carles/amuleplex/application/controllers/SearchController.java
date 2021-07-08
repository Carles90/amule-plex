package cloud.carles.amuleplex.application.controllers;

import cloud.carles.amuleplex.application.dto.search.SearchRequestDTO;
import cloud.carles.amuleplex.application.services.amulecmd.exception.AmuleCommandException;
import cloud.carles.amuleplex.application.services.gson.GsonContainer;
import cloud.carles.amuleplex.application.services.search.ResultsProvider;
import cloud.carles.amuleplex.application.services.search.SearchProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("search")
public class SearchController {
    @Autowired
    private SearchProcessor searchProcessor;

    @Autowired
    private ResultsProvider resultsProvider;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String results() throws AmuleCommandException {
        return GsonContainer.get().toJson(resultsProvider.provide());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String search(@RequestBody SearchRequestDTO search) throws AmuleCommandException {
        searchProcessor.process(search);
        return GsonContainer.get().toJson(search);
    }
}
