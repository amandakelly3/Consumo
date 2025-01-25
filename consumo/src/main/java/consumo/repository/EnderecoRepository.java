package consumo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import consumo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}