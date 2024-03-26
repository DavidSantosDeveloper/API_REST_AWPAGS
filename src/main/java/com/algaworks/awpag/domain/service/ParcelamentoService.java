package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.model.Parcelamento;
import com.algaworks.awpag.domain.repository.ClienteRepository;
import com.algaworks.awpag.domain.repository.ParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ParcelamentoService {

    private final ParcelamentoRepository parcelamentoRepository;
    private final CrudClienteService crudClienteService;
    private final ClienteRepository clienteRepository;

    @Transactional
    public Parcelamento cadastrar(Parcelamento novoParcelamento) {
        if (novoParcelamento.getId() != null) {
            throw new NegocioException("Parcelamento a ser criado não deve possuir um código");
        }

        clienteRepository.findById(novoParcelamento.getCliente().getId()).orElseThrow(()->new NegocioException("Cliente não encontrado."));
        
        Cliente cliente = crudClienteService.salvarCliente(novoParcelamento.getCliente());

        novoParcelamento.setCliente(cliente);
        novoParcelamento.setDataCriacao(LocalDateTime.now());

        return parcelamentoRepository.save(novoParcelamento);
    }

}
