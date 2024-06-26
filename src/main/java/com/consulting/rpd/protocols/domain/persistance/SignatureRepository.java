package com.consulting.rpd.protocols.domain.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.rpd.protocols.domain.model.Signature;

@Repository
public interface SignatureRepository extends JpaRepository<Signature, Long>{
    
}
