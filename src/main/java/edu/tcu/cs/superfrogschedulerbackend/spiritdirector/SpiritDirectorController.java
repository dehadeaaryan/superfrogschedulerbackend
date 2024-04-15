package edu.tcu.cs.superfrogschedulerbackend.spiritdirector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.tcu.cs.superfrogschedulerbackend.system.Result;

@RestController
public class SpiritDirectorController {
    private final SpiritDirectorService spiritDirectorService;

    public SpiritDirectorController(SpiritDirectorService spiritDirectorService) {
        this.spiritDirectorService = spiritDirectorService;
    }

    @GetMapping("/api/v1/spiritdirector/{spiritDirectorId}")
    public Result findSpiritDirectorById(@PathVariable String spiritDirectorId) {
        String message = String.format("requests: %s", spiritDirectorId);
        return new Result(true, 200, message);
    }

}
