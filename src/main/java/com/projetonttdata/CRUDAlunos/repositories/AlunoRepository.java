package com.projetonttdata.CRUDAlunos.repositories;

import com.projetonttdata.CRUDAlunos.dto.AlunoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetonttdata.CRUDAlunos.entities.Aluno;

@Repository
public interface AlunoRepository extends PagingAndSortingRepository<Aluno, Integer> {

    @Query("FROM Aluno a " +
            "WHERE LOWER(a.name) like %:searchTerm% " +
            "OR LOWER(a.email) like %:searchTerm%")
    Page<AlunoDTO> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);


}
