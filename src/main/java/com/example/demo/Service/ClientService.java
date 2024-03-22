package com.example.demo.Service;

import com.example.demo.Model.Client;
import com.example.demo.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientDao clientDao;
    public ResponseEntity<List<Client>> getAllClients() {
        try {
            return new ResponseEntity<>(clientDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity getClientById(String clientId) {
        try {
            Optional<Client> searchClient = clientDao.findById(Integer.parseInt(clientId));
            if(searchClient.isPresent())
                return new ResponseEntity<>(searchClient.get(), HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.OK).body("No client found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error encountered");
    }

    public void addClient(Client client) {
        clientDao.save(client);
    }
}
