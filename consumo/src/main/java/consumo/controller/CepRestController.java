package consumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import consumo.interfaces.CepService;
import consumo.model.Endereco;
import consumo.repository.EnderecoRepository;

@RestController
public class CepRestController {

    @Autowired
    private CepService cepService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
        
        Endereco endereco = cepService.buscaEnderecoPorCep(cep);
        
        if (endereco != null) {
            // Salvar o endereço no banco de dados
            enderecoRepository.save(endereco);
            return ResponseEntity.ok().body(endereco);
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
}
