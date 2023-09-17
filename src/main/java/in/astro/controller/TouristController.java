package in.astro.controller;

import in.astro.model.Tourist;
import in.astro.service.ITouristManagementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
    @Autowired
    private ITouristManagementService service;
    @PostMapping("/register")
    @ApiOperation("For Tourist Enrollment")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
            String message = service.registerTourist(tourist);
            return new ResponseEntity<String>(message,HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> displayTouristDetails(){
            List<Tourist> tourists = service.fetAllTourist();
            return new ResponseEntity<List>(tourists,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<>(tourist,HttpStatus.OK);
    }

    @PutMapping ("/modify")
    public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
            return new ResponseEntity<>(service.updateTourist(tourist),HttpStatus.OK);
    }

    @PatchMapping("/budgetModify/{id}/{hike}")
    public ResponseEntity<String> modifyTouristBudgetById(@PathVariable Integer id,@PathVariable Float hike){
            String msg = service.updateTouristById(id, hike);
            return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTouristById(@PathVariable Integer id){
            String msg = service.deleteTouristById(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
    }

}
