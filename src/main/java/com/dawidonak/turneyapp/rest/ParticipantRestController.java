package com.dawidonak.turneyapp.rest;

import com.dawidonak.turneyapp.domain.dto.AddParticipantDto;
import com.dawidonak.turneyapp.security.service.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ParticipantRestController {
    private final ParticipantService participantService;

    public ParticipantRestController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/create-participant")
    public ResponseEntity<?> addArmy(@RequestBody AddParticipantDto addParticipantDto){
        participantService.joinTournament(addParticipantDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/show-participants")
    public ResponseEntity<?> showParticipants(@RequestParam Long tournamentId){
        return new ResponseEntity<>(participantService.listAllPlayers(tournamentId),HttpStatus.OK);
    }

    @DeleteMapping("/leaveTournament")
    public ResponseEntity<?> leaveTournament(@RequestParam Long participantId){
        participantService.leaveTournament(participantId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
