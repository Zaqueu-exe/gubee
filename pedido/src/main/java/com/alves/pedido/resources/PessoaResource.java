package com.alves.pedido.resources;

import com.alves.pedido.Domain.Pessoa;
import com.alves.pedido.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
    @Autowired
    private PessoaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
