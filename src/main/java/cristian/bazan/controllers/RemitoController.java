package cristian.bazan.controllers;

import cristian.bazan.dtos.RemitoDto;
import cristian.bazan.models.Remito;
import cristian.bazan.services.RemitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("remito")
public class RemitoController {

    @Autowired
    private RemitoService remitoService;

    @GetMapping("")
    public ResponseEntity<List<Remito>> getActiveRemitoList(){

        List<Remito> remitos = remitoService.getAllRemitosByCondition(true);
        return ResponseEntity.ok(remitos);
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<Remito>> getInactiveRemitoList(){

        List<Remito> remitos = remitoService.getAllRemitosByCondition(false);
        return ResponseEntity.ok(remitos);
    }

    @GetMapping("/{remitoId}")
    public ResponseEntity<Remito> getRemito(@PathVariable Long remitoId){

        Remito remito = remitoService.getFullRemitoById(remitoId);
        return ResponseEntity.ok(remito);
    }

    @PostMapping("/create")
    public ResponseEntity<Remito> createRemito(@RequestBody RemitoDto remitoDto){

        return ResponseEntity.ok(remitoService.insertRemito(remitoDto));
    }

    @DeleteMapping("/delete/{remitoId}")
    public ResponseEntity<Boolean> deleteRemito(@PathVariable Long remitoId){

        return ResponseEntity.ok(remitoService.deleteRemito(remitoId));
    }

}
