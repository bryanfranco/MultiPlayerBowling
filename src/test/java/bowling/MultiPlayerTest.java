/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedago
 */
public class MultiPlayerTest {
    
    MultiPlayer game;
    String[] players = { "John", "Paul", "Georges", "Ringo" };
    
    public MultiPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new MultiPlayer();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lancementPartie(){
        try {
            assertEquals(game.startNewGame(players),"Prochain tir : Joueur John tour n°1 boule n°1");
        } catch (Exception ex) {
            Logger.getLogger(MultiPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void troisLancer() throws Exception{
        game.startNewGame(players);
        assertEquals(game.lancer(10), "Prochain tir : Joueur Paul tour n°1 boule n°1");
    }
    
    @Test(expected=Exception.class)
    public void lancerSansPartie() throws Exception{
        assertEquals(game.lancer(10), "Prochain tir : Joueur Paul tour n°1 boule n°1");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
