package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@GetMapping(path = "/api/detalleventas/{id}/infoventa")
	public @ResponseBody List<Map <String, Object>> infoventa(@PathVariable Integer id){
		String sql = "SELECT integrante.id as ID, musico.nombre as VENTA, producto.nombre as PRODUCTO FROM infoventa JOIN venta ON infoventa.id_venta=venta.id JOIN producto ON infoventa.id_producto=producto.id WHERE infoventa.id_detalleventa = ?";
		List<Map <String, Object>> queryResult = jdbcTemplate.queryForList(sql, id);
		return queryResult;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */

}