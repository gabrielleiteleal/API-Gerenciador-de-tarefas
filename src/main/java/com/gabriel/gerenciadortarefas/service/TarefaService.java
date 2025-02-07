package com.gabriel.gerenciadortarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gabriel.gerenciadortarefas.model.Tarefa;
import com.gabriel.gerenciadortarefas.repository.ITarefa;

@Service
public class TarefaService {

	private ITarefa repository;

	public TarefaService(ITarefa repository) {
		this.repository = repository;
	}

	public List<Tarefa> listarTarefas() {
		List<Tarefa> lista = repository.findAll();
		return lista;
	}

	public Tarefa recuperarTarefa(Integer id) {
		return repository.findById(id).orElse(new Tarefa());
	}

	public List<Tarefa> recuperarTarefaPorUsuario(Integer id_usuario) {
		return repository.findByUsuarioId(id_usuario);
	}

	public Tarefa criarTarefa(Tarefa tarefa) {
		Tarefa novaTarefa = repository.save(tarefa);
		return novaTarefa;
	}

	public Tarefa editarTarefa(Tarefa tarefa) {
		Tarefa novaTarefa = repository.save(tarefa);
		return novaTarefa;
	}

	public Boolean excluirTarefa(Integer id) {
		repository.deleteById(id);
		return true;
	}
}