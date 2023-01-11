package com.figroup.fiquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.figroup.fiquiz.entities.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long>{

}
