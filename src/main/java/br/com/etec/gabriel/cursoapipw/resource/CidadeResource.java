package br.com.etec.gabriel.cursoapipw.resource;

import br.com.etec.gabriel.cursoapipw.model.Cidade;
import br.com.etec.gabriel.cursoapipw.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/todos")
    public List<Cidade> ListarTodasCidades(){
        return cidadeRepository.findAll();
    }
}
