package cloud.carles.amuleplex.application.controllers;

import cloud.carles.amuleplex.application.dto.SuccessResponseDTO;
import cloud.carles.amuleplex.application.dto.download.DownloadRequestDTO;
import cloud.carles.amuleplex.application.services.amulecmd.exception.AmuleCommandException;
import cloud.carles.amuleplex.application.services.download.DownloadListProvider;
import cloud.carles.amuleplex.application.services.download.DownloadProcessor;
import cloud.carles.amuleplex.application.services.gson.GsonContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("download")
public class DownloadController {
    @Autowired
    private DownloadProcessor downloadProcessor;

    @Autowired
    private DownloadListProvider downloadListProvider;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String download(@RequestBody DownloadRequestDTO download) throws AmuleCommandException {
        downloadProcessor.process(download);
        return GsonContainer.get().toJson(new SuccessResponseDTO());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDownloads() throws AmuleCommandException {
        return GsonContainer.get().toJson(downloadListProvider.provide());
    }
}
