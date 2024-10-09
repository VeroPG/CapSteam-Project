package com.capgemini.capsteam.service;

import java.util.List;

import java.util.Optional;

import com.capgemini.capsteam.model.Game;

public interface GameService {
	
	//Metodo para obtener la lista de juegos
	public List<Game> findAll();
	
	/**
	 * Método para guardar y actualizar un juego
	 * @param game, el juego a guardar o actualizar
	 * @return void
	 */
	public void save(Game game);

	public void deleteById(int rank);
	
	/**
	 * Método para encontrar un juego por id
	 * @param rank, el id único para identificar el juego
	 * @return Optional<Game>
	 */
	public Optional<Game> findById(int rank);
}
