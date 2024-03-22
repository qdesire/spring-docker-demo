package com.example.demo.Service;

import com.example.demo.Model.Command;
import com.example.demo.dao.CommandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {
    @Autowired
    CommandDao commandDao;

    public List<Command> getAllCommands() {
        return commandDao.findAll();
    }

    public List<Command> getCommandsByClientId(Integer clientId) {
        return commandDao.findAllByClientidEquals(clientId);
    }

    public ResponseEntity addCommand(Command command) {
        try {
            commandDao.save(command);
            return ResponseEntity.status(HttpStatus.OK).body("Command added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error encountered : " + e.getMessage());
        }
    }
}
