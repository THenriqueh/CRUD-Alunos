package com.projetonttdata.CRUDAlunos.repositories;

import com.projetonttdata.CRUDAlunos.dto.AlunoDTO;
import com.projetonttdata.CRUDAlunos.entities.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query("FROM Aluno a " +
            "WHERE LOWER(a.name) like %:name% " +
            "OR LOWER(a.email) like %:email")
    Page<AlunoDTO> search(
            @Param("name") String name,
            Pageable pageable);


}
