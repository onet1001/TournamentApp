package com.dawidonak.turneyapp.rest;

import com.dawidonak.turneyapp.domain.dto.AddTournamentDto;
import com.dawidonak.turneyapp.security.service.TournamentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TournamentRestController {
    private final TournamentService tournamentService;

    public TournamentRestController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping("/add-tournament")
    public ResponseEntity<?> addTournament(@RequestBody AddTournamentDto addTournamentDto){
        tournamentService.createTournament(addTournamentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/show-tournaments")
    public ResponseEntity<?> showTournament(){
        return new ResponseEntity<>(tournamentService.listAllTournaments(),HttpStatus.OK);
    }

    @GetMapping("/show-details")
    public ResponseEntity<?> showTournamentDetails(@RequestParam Long tournamentId){
        return new ResponseEntity<>(tournamentService.tournamentDetails(tournamentId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteTournament")
    public ResponseEntity<?> deleteTournament(@RequestParam Long tournamentId){
        tournamentService.deleteTournament(tournamentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
