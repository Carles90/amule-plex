package cloud.carles.amuleplex.application.controllers;

import cloud.carles.amuleplex.application.services.amulecmd.exception.AmuleCommandException;
import cloud.carles.amuleplex.application.services.download.IncomingListProvider;
import cloud.carles.amuleplex.application.services.gson.GsonContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("incoming")
public class IncomingController {
    @Autowired
    private IncomingListProvider incomingListProvider;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getIncomingFiles() throws AmuleCommandException {
        return GsonContainer.get().toJson(incomingListProvider.provide());
    }
}
