package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Controller;

import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.BranchDto;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.SaleDto;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Service.IBranchService;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/branch")
public class BranchController {

    //Dependency injection
    @Autowired
    private IBranchService branchService;

    //CRUD
    //Create
    @PostMapping
    public ResponseEntity<?> CreateBranch(@RequestBody BranchDto branch) {
        branchService.CreateBranch(branch);

        return ResponseEntity.ok().build();
    }

    //Read
    //Get all
    @GetMapping
    public ResponseEntity<?> getBranches() {
        return ResponseEntity.ok().body(branchService.getBranches());
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateBranch(@PathVariable Long id, @RequestBody BranchDto branch) {
        return ResponseEntity.ok(branchService.UpdateBranch(id, branch));
    }

    //Delete
    @DeleteMapping
    public ResponseEntity<?> DeleteBranch(@RequestParam Long id) {
        branchService.DeleteBranch(id);

        return ResponseEntity.notFound().build();
    }
}
