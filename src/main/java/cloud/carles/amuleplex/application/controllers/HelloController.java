package cloud.carles.amuleplex.application.controllers;

import cloud.carles.amuleplex.application.dto.SuccessResponseDTO;
import cloud.carles.amuleplex.application.services.gson.GsonContainer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return GsonContainer.get().toJson(new SuccessResponseDTO());
    }
}
