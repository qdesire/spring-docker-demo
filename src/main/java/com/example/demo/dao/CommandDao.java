package com.example.demo.dao;

import com.example.demo.Model.Client;
import com.example.demo.Model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandDao extends JpaRepository<Command, Integer> {
    List<Command> findAllByClientidEquals(Integer clientid);
}
