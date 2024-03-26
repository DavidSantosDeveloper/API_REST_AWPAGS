package com.algaworks.awpag.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.repository.ClienteRepository;

@Service
public class CrudClienteService {
    
    private ClienteRepository clienteRepository;

    public CrudClienteService(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    @Transactional
    public Cliente salvarCliente(Cliente cliente){
    //    REGRA DE NEGOCIO
    boolean verificao_se_email_ja_esta_sendo_usado_por_outro_cliente=clienteRepository
    .findByEmail(cliente.getEmail())
    .filter(c-> !c.equals(cliente))
    .isPresent();
    
    if(verificao_se_email_ja_esta_sendo_usado_por_outro_cliente==true){
        throw  new NegocioException("Já existe um cliente cadrastrado com este e-mail.");
    }

       return  clienteRepository.save(cliente);
    }
    @Transactional
    public void excluirCliente(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }

   
}
