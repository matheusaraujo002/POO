package br.edu.univille.poo.JPA.repositorio;

import br.edu.univille.poo.JPA.entidade.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findAllByFinalizadoFalse();

    List<Tarefa> findAllByFinalizadoTrue();

    List<Tarefa> findAllByDataPrevistaFinalizacaoBeforeAndFinalizadoFalse(LocalDate dataAtual);

    List<Tarefa> findAllByDataPrevistaFinalizacaoBetweenAndFinalizadoFalse(LocalDate dataInicio, LocalDate dataFim);
}