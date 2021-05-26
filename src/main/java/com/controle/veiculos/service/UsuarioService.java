package com.controle.veiculos.service;

import com.controle.veiculos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

//    @Transactional(readOnly = true)
//    public List<Usuario> findAll() {
//        List<Usuario> result = repository.findAll();
//        return result;
//    }

//    @Transactional(readOnly = true)
//    public void createUser(Usuario novoUsuario) {
//        repository.save(novoUsuario);
//    }
////
//    @Transactional(readOnly = true)
//    public List<SaleSucessDTO> sucessGroupedBySeller() {
//        return repository.sucessGroupedBySeller();
//    }
}

