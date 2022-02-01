package com.dawidonak.turneyapp.rest;


import com.dawidonak.turneyapp.domain.dto.AddGameDto;
import com.dawidonak.turneyapp.domain.dto.ChangeGamePairs;
import com.dawidonak.turneyapp.domain.dto.EditGameResultDto;
import com.dawidonak.turneyapp.security.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GameRestController {
    public final GameService gameService;


    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/create-paring")
    public ResponseEntity<?> createMatchup(@RequestBody AddGameDto addGameDto){
        gameService.createMatchUp(addGameDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit-result")
    public ResponseEntity<?> editResult(@RequestBody EditGameResultDto editGameResultDto){
        gameService.editResult(editGameResultDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/game-history")
    public ResponseEntity<?> gameHistory(@RequestParam Long participantId){
        return new ResponseEntity<>(gameService.gameHistory(participantId),HttpStatus.OK);
    }

    @PostMapping("/create-first-bracket")
    public ResponseEntity<?> createFirstBracket(@RequestParam Long tournamentId){
        gameService.createFirstBracket(tournamentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create-bracket")
    public ResponseEntity<?> createBracket(@RequestParam Long tournamentId){
        gameService.createBracket(tournamentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/change-opponents")
    public ResponseEntity<?> changeOppone(@RequestBody ChangeGamePairs changeGamePairs){
        gameService.changeOpponent(changeGamePairs);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @GetMapping("/all-game-history")
//    public ResponseEntity<?> allGameHistory(@RequestParam Long userId){
//        return new ResponseEntity<>(gameService.gameAllHistory(userId),HttpStatus.OK);
//    }


}
