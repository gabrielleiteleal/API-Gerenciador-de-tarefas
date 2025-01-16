package com.gabriel.gerenciadortarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.gabriel.gerenciadortarefas.model.Tarefa;
import com.gabriel.gerenciadortarefas.model.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class SistemaController {

	private final String TAREFA_ENDPOINT = "http://localhost:8080/tarefa";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/sistema")
	public String sistema(HttpSession session, Model model) {

		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		if(usuario == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("usuario", usuario);
		
		String url = TAREFA_ENDPOINT + "/usuario/" + usuario.getId();

		Tarefa[] tarefas = restTemplate.getForObject(url, Tarefa[].class);
		model.addAttribute("tarefas", tarefas);

		return "sistema";
	}

}
