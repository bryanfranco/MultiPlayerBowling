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
    
    Multiplayer game;
    String[] players = { "John", "Paul", "Georges", "Ringo" };
    String[] playersVide = {};
    
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
        game = new Multiplayer();
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
        System.out.println("Liste : " + game.listeJoueurs.toString());
        assertEquals("Prochain tir : Joueur Paul tour n°1 boule n°1",game.lancer(10));
        System.out.println(game.scoreJoueurs.get(game.joueurCourant).score());
        assertEquals(game.lancer(3), "Prochain tir : Joueur Paul tour n°1 boule n°2");
        assertEquals(game.lancer(7), "Prochain tir : Joueur Georges tour n°1 boule n°1");
        assertEquals(game.lancer(0), "Prochain tir : Joueur Georges tour n°1 boule n°2");
        assertEquals(game.lancer(0), "Prochain tir : Joueur Ringo tour n°1 boule n°1");
    }
    
    @Test(expected=Exception.class)
    public void lancerSansPartie() throws Exception{
        assertEquals(game.lancer(10), "Prochain tir : Joueur Paul tour n°1 boule n°1");
    }
    
    @Test
    public void affichageScore() throws Exception{
        game.startNewGame(players);
        game.lancer(10);
        game.lancer(3);
        game.lancer(7);
        game.lancer(0);
        game.lancer(0);
        assertEquals(game.scoreFor("John"), 10);
        assertEquals(game.scoreFor("Paul"),10);
        assertEquals(game.scoreFor("Georges"),0);
        assertEquals(game.scoreFor("Ringo"),0);
    }
    
    @Test(expected=Exception.class)
    public void playerDoesntExist() throws Exception{
        game.startNewGame(players);
        assertEquals(game.scoreFor("Lestin"), 300);
    }
    
    @Test(expected=Exception.class)
    public void noPlayers() throws Exception{
        game.startNewGame(playersVide);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
