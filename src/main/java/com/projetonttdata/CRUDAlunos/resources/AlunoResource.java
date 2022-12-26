package com.projetonttdata.CRUDAlunos.resources;

import com.projetonttdata.CRUDAlunos.dto.AlunoDTO;
import com.projetonttdata.CRUDAlunos.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController(value = "HttpGet")
@RequestMapping(value = "/alunos")
@CrossOrigin("*")

public class AlunoResource {

    @Autowired
    private AlunoService service;

    @GetMapping("/search")
    public ResponseEntity<Page<AlunoDTO>> findAll(@Validated Pages pages) {
        return (ResponseEntity<Page<AlunoDTO>>) service.findAll(pages);
    }

    @GetMapping
    public Page<AlunoDTO> getAll(@Validated Pages pages) {
        return service.findAll(pages);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable Integer id) {
        AlunoDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Integer id, @RequestBody AlunoDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
