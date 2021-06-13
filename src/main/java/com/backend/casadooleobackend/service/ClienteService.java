package com.backend.casadooleobackend.service;

import com.backend.casadooleobackend.dto.ClienteDTO;
import com.backend.casadooleobackend.model.Cliente;
import com.backend.casadooleobackend.repositories.ClienteRepositories;
import com.backend.casadooleobackend.service.exceptions.ObjectionNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private ClienteRepositories clienteRepositories;

    public List<ClienteDTO> findAll () {
        List<Cliente> result = clienteRepositories.findAll();
        return result.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
    }

    public Cliente findById (int id) {
        //optional tem a função de escolha se vai ter o id ou não
        Optional<Cliente> obj = clienteRepositories.findById(id);
        //se retorna sem id a orElseThorow "ou Então jogue"
        //tem a função
        return obj.orElseThrow(() -> new ObjectionNotFountException("Cliente não encontrado " + id));
    }

    //sava um novo objeto eu passo no paramento (Objeto <obj>)
    public Cliente create (Cliente obj) {
        //o metodo getIdCliente recebe o valor null e a função save criar um novo objeto
        obj.getIdCliente();
        return clienteRepositories.save(obj);
    }

    //Objeto cliente eu chamo da model e para fazer as comparação se existe eu passo como parametro
    //e chamo o id "int com nome parametro id, e chamando o dto clienteDTO"
    public Cliente update (int id, ClienteDTO objDto) {
        //chamo o objeto cliente para fazer a comparação se existem que chamo no metodo findById (<objeto id>)
        Cliente obj = findById(id);
        //criado a variavel obj o set pega o valor do objeto e o get atualizar o objeto
        obj.setNome(objDto.getNome());
        obj.setEmail(objDto.getEmail());
        obj.setEndereco(objDto.getEndereco());
        obj.setTelefone(objDto.getTelefone());
        //retorna os novos valores do objeto <obj>
        return clienteRepositories.save(obj);
    }

    public void delete (int idCliente) {
        //vai fazer a verificação se existem o objeto
        findById(idCliente);
        //tentar
        try{
            clienteRepositories.deleteById(idCliente);
            //pega
        }catch (DataIntegrityViolationException e){
            //lança novo
            throw new DataIntegrityViolationException("Objeto não pode ser deletado!!!");
        }

    }

}
