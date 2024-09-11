package br.edu.univille.poo.JPA.controller;

import br.edu.univille.poo.JPA.entidade.Tarefa;
import br.edu.univille.poo.JPA.servico.TarefaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaRestController {

    @Autowired
    private TarefaServico tarefaServico;

    @GetMapping
    public List<Tarefa> obterTodas() {
        return tarefaServico.obterTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> obterPeloId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaServico.obterPeloId(id);
        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Tarefa incluir(@RequestBody Tarefa tarefa) {
        return tarefaServico.incluir(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        try {
            return ResponseEntity.ok(tarefaServico.atualizar(tarefa));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            tarefaServico.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/nao-finalizadas")
    public List<Tarefa> obterTarefasNaoFinalizadas() {
        return tarefaServico.obterTarefasNaoFinalizadas();
    }

    @GetMapping("/finalizadas")
    public List<Tarefa> obterTarefasFinalizadas() {
        return tarefaServico.obterTarefasFinalizadas();
    }

    @GetMapping("/atrasadas")
    public List<Tarefa> obterTarefasAtrasadas() {
        return tarefaServico.obterTarefasAtrasadas();
    }

    @GetMapping("/nao-finalizadas-entre")
    public List<Tarefa> obterTarefasNaoFinalizadasEntreDatas(@RequestParam LocalDate dataInicio, @RequestParam LocalDate dataFim) {
        return tarefaServico.obterTarefasNaoFinalizadasEntreDatas(dataInicio, dataFim);
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Tarefa> finalizarTarefa(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tarefaServico.finalizarTarefa(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}