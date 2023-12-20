package com.caiovelp.charmakerbackend.controller;

import com.caiovelp.charmakerbackend.model.Race;
import com.caiovelp.charmakerbackend.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private RaceService raceService;

    @GetMapping
    public List<Race> getRaces() {
        return raceService.getRaces();
    }

    @GetMapping("{idRace}")
    public Race getRaceById(@PathVariable("idRace") Long id) {
        return raceService.getRaceById(id);
    }

    @PostMapping
    public Race cadastrarPersonagem(@RequestBody Race race) {
        return raceService.cadastrarRace(race);
    }
}
