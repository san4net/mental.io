package com.mental.io.data.repos;

import com.mental.io.data.Audios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends JpaRepository<Audios, Long> {
}
