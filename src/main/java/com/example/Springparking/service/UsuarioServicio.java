package com.example.Springparking.service;

import com.example.Springparking.controller.dto.UsuarioRegistroDTO;
import com.example.Springparking.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();



	
}
