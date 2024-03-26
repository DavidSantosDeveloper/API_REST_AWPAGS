package com.algaworks.awpag.api.controller;

// import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.repository.ClienteRepository;
import com.algaworks.awpag.domain.service.CrudClienteService;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;


@AllArgsConstructor        // gera um construtor automaticamente
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    // criacao e injencao de uma instacia desse objeto que gerencia a ligacao classe-tabela do bd
    //@PersistenceContext
    //private EntityManager manager;

    // Autowired - injeta uma instacia de um objeto do tipo que esta abaixo
    @Autowired
    private ClienteRepository clienteRepository;

    // autowired ou via construtor(mais indicada pro codico conseguir ser melhor testado) -pra injetar depedencias na classe
   
    // public ClienteController(ClienteRepository clienteRepository){
        // this.clienteRepository=clienteRepository;
    // }

    @Autowired
    private CrudClienteService crudClienteService;

    @GetMapping("")
    public List<Cliente> listar(){
        
        /*  Cliente cliente=new Cliente();
          cliente.setId(1L);
          cliente.setNome("Davi");
          cliente.setEmail("emailteste@gmail.com");
         cliente.setTelefone("99988-2554");
        
         return Arrays.asList(cliente);
         */

        
         //  linguagem de consulta jpql
        // return manager.createQuery("from Cliente",Cliente.class).getResultList();

        return clienteRepository.findAll();
     }

     @GetMapping("/{clienteId}")
     public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long clienteId){
        Optional<Cliente> pesquisaPeloCliente=clienteRepository.findById(clienteId);

        if(pesquisaPeloCliente.isPresent()){
            return ResponseEntity.ok(pesquisaPeloCliente.get()); 
        }
        else{
            return ResponseEntity.notFound().build();
        }
     }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
     public Cliente cadrastrarCliente(@Valid @RequestBody  Cliente cliente){
        // return clienteRepository.save(cliente);
        return crudClienteService.salvarCliente(cliente);
     }

     @PutMapping("/{clienteId}")
     public ResponseEntity<Cliente>atualizarCliente(@PathVariable Long clienteId,@Valid @RequestBody Cliente cliente){
         if(clienteRepository.existsById(clienteId)==false){
             return ResponseEntity.notFound().build();
         }
        //  associa o id passado via url ao objeto java criado(que foi criado via dados do corpo body)
         cliente.setId(clienteId);
        //  metodo save verifica existe um cliente com id informado:Se sim,atualiza os dados.Senão cria um novo registro na tabela cliente 
        //  clienteRepository.save(cliente);
        crudClienteService.salvarCliente(cliente);
        //  retorna operacao PUT feita com sucesso! e envia uma resposta com o json que representa o cliente
         return ResponseEntity.ok(cliente);
     }

     @DeleteMapping("/{clienteId}")
     public ResponseEntity<Void> deletarCliente(@PathVariable Long clienteId){
        if(clienteRepository.existsById(clienteId)==false){
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(clienteId);
        // Executou com suceeso e resposta sem body (Ideal para metodo http delete)
        return ResponseEntity.noContent().build();
     }

     @ExceptionHandler(NegocioException.class)
     public ResponseEntity<String> capturarExcecao(NegocioException erro){
        return ResponseEntity.badRequest().body(erro.getMessage());
     }
}
