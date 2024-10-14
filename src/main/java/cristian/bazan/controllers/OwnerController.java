package cristian.bazan.controllers;

import cristian.bazan.dtos.OwnerDto;
import cristian.bazan.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("")
    public ResponseEntity<OwnerDto> getOwner(){

        OwnerDto ownerDto = ownerService.getOwner();
        return ResponseEntity.ok(ownerDto);
    }

    @PutMapping("/edit")
    public ResponseEntity<OwnerDto> editOwner(@RequestBody OwnerDto ownerDto){

        return ResponseEntity.ok(ownerService.updateOrCreateOwner(ownerDto));
    }
}
