package com.example.demo.Controller;

import com.example.demo.Model.Command;
import com.example.demo.Service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("command")
public class CommandController {

    @Autowired
    CommandService commandService;

    @GetMapping("allCommands")
    public List<Command> getAllCommands() {
        return commandService.getAllCommands();
    }

    @GetMapping("/id/{clientId}")
    public List<Command> getCommandsByClientId(@PathVariable String clientId) {
        return commandService.getCommandsByClientId(Integer.parseInt(clientId));
    }

    @PostMapping("add")
    public ResponseEntity addCommand(@RequestBody Command command) {
        return commandService.addCommand(command);
    }
}
