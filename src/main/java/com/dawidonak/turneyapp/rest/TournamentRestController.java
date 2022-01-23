package com.dawidonak.turneyapp.rest;

import com.dawidonak.turneyapp.domain.dto.AddTournamentDto;
import com.dawidonak.turneyapp.security.service.TournamentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TournamentRestController {
    private final TournamentService tournamentService;

    public TournamentRestController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping("/addTournament")
    public ResponseEntity<?> addTounrament(@RequestBody AddTournamentDto addTournamentDto){
        tournamentService.createTournament(addTournamentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/showTournaments")
    public ResponseEntity<?> showTounrament(){
        return new ResponseEntity<>(tournamentService.listAllTournaments(),HttpStatus.OK);
    }

}
