package cloud.carles.amuleplex.application.controllers;

import cloud.carles.amuleplex.application.dto.SuccessResponseDTO;
import cloud.carles.amuleplex.application.dto.download.DeleteIncomingDTO;
import cloud.carles.amuleplex.application.dto.download.OrderIncomingDTO;
import cloud.carles.amuleplex.application.services.download.IncomingFileOrderer;
import cloud.carles.amuleplex.application.services.download.IncomingFileRemover;
import cloud.carles.amuleplex.application.services.download.IncomingListProvider;
import cloud.carles.amuleplex.application.services.download.ShowsFoldersProvider;
import cloud.carles.amuleplex.application.services.gson.GsonContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("incoming")
public class IncomingController {
    @Autowired
    private IncomingListProvider incomingListProvider;

    @Autowired
    private IncomingFileOrderer incomingFileOrderer;

    @Autowired
    private IncomingFileRemover incomingFileRemover;

    @Autowired
    private ShowsFoldersProvider showsFoldersProvider;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getIncomingFiles() {
        return GsonContainer.get().toJson(incomingListProvider.provide());
    }

    @PostMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestBody DeleteIncomingDTO request) throws IOException {
        incomingFileRemover.remove(request);
        return GsonContainer.get().toJson(new SuccessResponseDTO());
    }

    @PostMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public String order(@RequestBody OrderIncomingDTO request) throws IOException {
        incomingFileOrderer.order(request);
        return GsonContainer.get().toJson(new SuccessResponseDTO());
    }

    @GetMapping(path = "/shows", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getShows() {
        return GsonContainer.get().toJson(showsFoldersProvider.provide());
    }
}
