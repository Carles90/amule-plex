package cloud.carles.amuleplex.application.controllers;

import cloud.carles.amuleplex.application.dto.SuccessResponseDTO;
import cloud.carles.amuleplex.application.dto.download.DownloadRequestDTO;
import cloud.carles.amuleplex.application.services.amulecmd.exception.AmuleCommandException;
import cloud.carles.amuleplex.application.services.download.*;
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

    @Autowired
    private PauseProcessor pauseProcessor;

    @Autowired
    private ResumeProcessor resumeProcessor;

    @Autowired
    private CancelProcessor cancelProcessor;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String download(@RequestBody DownloadRequestDTO download) throws AmuleCommandException {
        downloadProcessor.process(download);
        return GsonContainer.get().toJson(new SuccessResponseDTO());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDownloads() throws AmuleCommandException {
        return GsonContainer.get().toJson(downloadListProvider.provide());
    }

    @PostMapping(path = "/{fileId}/pause", produces = MediaType.APPLICATION_JSON_VALUE)
    public String pause(@PathVariable String fileId) throws AmuleCommandException {
        pauseProcessor.process(fileId);
        return GsonContainer.get().toJson(new SuccessResponseDTO());
    }

    @PostMapping(path = "/{fileId}/resume", produces = MediaType.APPLICATION_JSON_VALUE)
    public String resume(@PathVariable String fileId) throws AmuleCommandException {
        resumeProcessor.process(fileId);
        return GsonContainer.get().toJson(new SuccessResponseDTO());
    }

    @DeleteMapping(path = "/{fileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable String fileId) throws AmuleCommandException {
        cancelProcessor.process(fileId);
        return GsonContainer.get().toJson(new SuccessResponseDTO());
    }
}
