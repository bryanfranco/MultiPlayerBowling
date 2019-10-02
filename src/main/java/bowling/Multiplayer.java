/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import java.util.ArrayList;

/**
 *
 * @author pedago
 */
public class Multiplayer implements MultiPlayerGame{
    
        ArrayList<String> listeJoueurs = new ArrayList<>();
        ArrayList<SinglePlayerGame> scoreJoueurs = new ArrayList<>();
        int joueurCourant = -1;
        
        public Multiplayer(){
            
        }

    @Override
    public String startNewGame(String[] playerName) throws Exception {
        if(playerName.length == 0){
            throw new UnsupportedOperationException("Aucun joueur n'a été ajouté."); //To change body of generated methods, choose Tools | Templates.
        }
        for(int i=0 ; i<playerName.length ; i++){
            this.listeJoueurs.add(playerName[i]);
            this.scoreJoueurs.add(new SinglePlayerGame());
        }
        System.out.println(this.scoreJoueurs.toString());
        this.joueurCourant++;
        return "Prochain tir : Joueur " + this.listeJoueurs.get(joueurCourant) + " tour n°" + this.scoreJoueurs.get(joueurCourant).getFrameNumber() + " boule n°" + this.scoreJoueurs.get(joueurCourant).getNextBallNumber();
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        if(this.joueurCourant == -1){
            throw new UnsupportedOperationException("La partie n'a pas commencé"); //To change body of generated methods, choose Tools | Templates.
        }
        this.scoreJoueurs.get(joueurCourant).lancer(nombreDeQuillesAbattues);
        if(this.scoreJoueurs.get(joueurCourant).hasCompletedFrame()){
            if(this.joueurCourant+1 > this.listeJoueurs.size()){
                this.joueurCourant=0;
            }
            this.joueurCourant++;
        }

        return "Prochain tir : Joueur " + this.listeJoueurs.get(joueurCourant) + " tour n°" + this.scoreJoueurs.get(joueurCourant).getFrameNumber() + " boule n°" + this.scoreJoueurs.get(joueurCourant).getNextBallNumber();
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        if(!this.listeJoueurs.contains(playerName)){
            throw new UnsupportedOperationException("Le joueur n'existe pas"); //To change body of generated methods, choose Tools | Templates.
        }
        int indice = 0;
        while(playerName != this.listeJoueurs.get(indice)){
            indice++;
        }
        return this.scoreJoueurs.get(indice).score();
        
    }
    
}
