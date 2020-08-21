package com.example.TestJwtProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecurityController {

	@GetMapping("/acceso_jwt")
	public ResponseEntity<?> getInformacionBancaria(){
		List<String> movimientoBancario = obtenerMovimientosBancarios();
		
		if(movimientoBancario.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(movimientoBancario, HttpStatus.OK);
		}
	}
	
	private List<String> obtenerMovimientosBancarios(){
		List<String> movimientosBancarios = new ArrayList<>();
		movimientosBancarios.add("500 dolar");
		movimientosBancarios.add("200 dolar");
		movimientosBancarios.add("300 dolar");
		movimientosBancarios.add("5500 dolar");
		movimientosBancarios.add("25000 dolar");
		
		return movimientosBancarios;
	}
}
