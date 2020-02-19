package info.devlink.developerservice.controller;

import info.devlink.developerservice.model.Developer;
import info.devlink.developerservice.repository.DeveloperRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/developers")
public class DeveloperController {

    private final DeveloperRepository developerRepository;

    public DeveloperController(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @PostMapping()
    public @ResponseBody
    Mono<Developer> addKayak(@RequestBody Developer developer) {
        return developerRepository.save(developer);
    }

    @GetMapping()
    public @ResponseBody
    Flux<Developer> getAllKayaks() {
        Flux<Developer> result = developerRepository.findAll();
        return result;
    }
}
