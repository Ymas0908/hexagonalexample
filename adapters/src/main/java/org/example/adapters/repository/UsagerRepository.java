package org.example.adapters.repository;

import org.example.adapters.model.UsagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsagerRepository extends JpaRepository<UsagerEntity, Integer> {

    List<UsagerEntity> findByNomIsContainingIgnoreCase(String nom);

    UsagerEntity findByEmailContainingIgnoreCase(String email);

}
