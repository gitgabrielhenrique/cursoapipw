package br.com.etec.gabriel.cursoapipw.resource;

import br.com.etec.gabriel.cursoapipw.model.Cidade;
import br.com.etec.gabriel.cursoapipw.repository.CidadeRepository;
import br.com.etec.gabriel.cursoapipw.repository.filter.CidadeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
    @Autowired
    private CidadeRepository cidadeRepository;
  @GetMapping()
  private Page<Cidade> query(CidadeFilter cidadeFilter, Pageable pageable)
  {
    return cidadeRepository.filtrar(cidadeFilter, pageable);
  }


    @GetMapping("/todos")
    public List<Cidade> ListarTodasCidades(){
        return cidadeRepository.findAll();
    }
}
