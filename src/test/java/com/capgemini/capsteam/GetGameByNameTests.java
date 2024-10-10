package com.capgemini.capsteam;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) 
public class GetGameByNameTests {

    @Mock
    private GameService service; 

    @Mock
    private Model model; 

    @InjectMocks
    private GameController controller; 
    
    
    @Test
    public void testSearchGameByName_withName() {  
        
        Game game1 = new Game();
        game1.setName("FIFA");

        Game game2 = new Game();
        game2.setName("FIFA 21");

        List<Game> mockGames = Arrays.asList(game1, game2);

        when(service.getGameByName("FIFA")).thenReturn(mockGames);
        String viewName = controller.searchGame("FIFA", null, model);

        // Verificar que el modelo tiene los atributos correctos
        verify(model).addAttribute("games", mockGames);
        verify(model).addAttribute("name", "FIFA");

        // Verificar que el nombre de la vista es el correcto
        assertEquals("gameSearch.html", viewName);
    }

    @Test
    	// Simular una búsqueda con una cadena vacía
    public void testSearchGameByName_withoutName() {
       
        String viewName = controller.searchGame(null, null, model);

        verify(service, never()).getGameByName(anyString());

        assertEquals("gameSearch.html", viewName);
    }
    
    @Test
    public void testSearchGameByName() {
        
        String gameName = "FIFA";

        String viewName = controller.searchGame(gameName,null, model);

        assertEquals("gameSearch.html", viewName);


    }

}
