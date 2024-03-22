package com.example.demo.Controller;

import com.example.demo.Model.Client;
import com.example.demo.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("allClients")
    public ResponseEntity<List<Client>> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/id/{clientId}")
    public ResponseEntity getClientById(@PathVariable String clientId){
        return clientService.getClientById(clientId);
    }

    @PostMapping("add")
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        clientService.addClient(client);
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

}
