package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.entity.Client;
import ru.mak.tradingCompany.repo.ClientRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;

    public Client getById(Long id) {
        try {
            return clientRepo.getReferenceById(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void save(Client client) {
        clientRepo.save(client);
    }

    public void delete(Long id) {
        clientRepo.deleteById(id);
    }

    public List<Client> getAll() {
        return clientRepo.findAll();
    }
}
