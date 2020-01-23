package org.cerner.multiplex.packageinfo.resource;


import java.util.List;

import org.cerner.multiplex.packageinfo.dao.PackageDetailsDAO;
import org.cerner.multiplex.packageinfo.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class PackageResource {

    @Autowired
    private PackageDetailsDAO<Integer, Package> hospitalDAO;

    @PostMapping("/package")
    public ResponseEntity<List<Package>> add(@RequestBody List<Package> hospitals)
    {
        for(Package hospital : hospitals)
            hospitalDAO.add(hospital.getId(), hospital);
        return new ResponseEntity<>(hospitals,HttpStatus.OK);
    }

    @GetMapping("/package/{id}")
    ResponseEntity<List<Package>> get(@PathVariable("id") String id)
    {
        int key = Integer.parseInt(id);
        return ResponseEntity.status(HttpStatus.OK).body(hospitalDAO.get(key));
    }

    @PutMapping("/package")
    public ResponseEntity<Package> update(@RequestBody Package hospital)
    {
        hospitalDAO.addOrUpdate(hospital.getId(), hospital);
        return new ResponseEntity<>(hospital, HttpStatus.OK);
    }

    @DeleteMapping(value = "/package/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        int key = Integer.parseInt(id);
        boolean isRemoved = hospitalDAO.remove(key);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
