package com.dawidonak.turneyapp.rest;

import com.dawidonak.turneyapp.domain.dto.AddArmyDto;
import com.dawidonak.turneyapp.domain.dto.AddTournamentDto;
import com.dawidonak.turneyapp.domain.dto.EditArmyDto;
import com.dawidonak.turneyapp.security.service.ArmyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ArmyRestController {
    public final ArmyService armyService;

    public ArmyRestController(ArmyService armyService) {
        this.armyService = armyService;
    }

    @PostMapping("/add-army")
    public ResponseEntity<?> addArmy(@RequestBody AddArmyDto addArmyDto){
        armyService.addArmy(addArmyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit-army")
    public ResponseEntity<?> editArmy(@RequestBody EditArmyDto editArmyDto){
        armyService.editArmy(editArmyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-army")
    public ResponseEntity<?> getArmy(@RequestParam Long armyId){
        return new ResponseEntity<>(armyService.getArmy(armyId),HttpStatus.OK);
    }
}
