package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.ClientDto;
import ru.mak.tradingCompany.entity.Client;
import ru.mak.tradingCompany.repo.ClientRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;

    public ClientDto getById(Long id) {
        Client client = clientRepo.findById(id).orElse(null);
        return (client == null) ? null : client.toClientDto();
    }

    public void save(ClientDto client) {
        clientRepo.save(new Client(client));
    }

    public void delete(Long id) {
        clientRepo.deleteById(id);
    }

    public List<ClientDto> getAll(Pageable pageable) {
        return clientRepo.findAll(pageable).stream().map(Client::toClientDto).collect(Collectors.toList());
    }
}
