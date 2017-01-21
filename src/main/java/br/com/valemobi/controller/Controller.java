package br.com.valemobi.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.valemobi.dao.MercadoriaDao;
import br.com.valemobi.dominio.Mercadoria;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private MercadoriaDao mercDao;
	private HashMap<String, Object> msg;
	private String retorno;
	
	public Controller() {
		msg = new HashMap<String, Object>();
		msg.put("msg", "operacao Realizada com Sucesso");
	
	}
	
	@RequestMapping(value="/mercadoria", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HashMap<String,Object> salvarMercadoria(@RequestBody Mercadoria mercadoria){
		mercDao.verificaAcao(mercadoria);
		return msg;
		
	}
	
	@RequestMapping(value="/mercadoria/{id}", method=RequestMethod.DELETE)
	public @ResponseBody HashMap<String,Object> excluirMercadoria(@PathVariable Integer id){
		mercDao.excluir(id);
		return msg;
	}
	
	@RequestMapping(value="/mercadoria", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Mercadoria> listarMercadoria(){
		return mercDao.listar();
		
	}
	
	@RequestMapping(value="/mercadoria", method=RequestMethod.PUT)
	public void alterarMercadoria(@RequestBody Mercadoria mercadoria){
		
	}
}
