package com.cnu.devblog.repository.persistence.slang;

import com.cnu.devblog.entity.Slang;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlangRepository extends JpaRepository<Slang, Long> {
}
