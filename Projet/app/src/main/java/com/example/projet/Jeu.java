package com.example.projet;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

/**
 * Permet de gérer le jeu.
 *
 * @author Emeric Mottier
 * @version 2.0
 */

public class Jeu {

	/**
	 * Liste de joueur.
	 */
	public Joueur[] joueurs;


	public int lon;

	public int lar;

	public int tour;

	public Button next;

	public Button lancerDe;

	public int[] diceImages;

	public ImageView dice;


	public int posX [] = { -1 , -1 , -1, -1 , -1 , -2 , -3  , -4 , -5 , -6 , -7 , -7 , -7 ,
			-6 , -5 , -4, -3 , -2 , -1 , -1 , -1 , -1 , -1 , -1 , 0 , 1 ,
			1 , 1 , 1 , 1 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 7 , 7 ,
			6 , 5 , 4 , 3 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 0 , -1 };
	private int posY [] = {  -6 , -5 , -4, -3 , -2 , -1 , -1 , -1 , -1 , -1 , -1 , 0 , 1 ,
			1 , 1 , 1 , 1 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 7 , 7 ,
			6 , 5 , 4 , 3 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 0 , -1 ,
			-1 , -1 , -1, -1 , -1 , -2 , -3  , -4 , -5 , -6 , -7 , -7 , -7 };

	/**
	 * Constructeur
	 */
	public Jeu(int longueur, int largueur , Button next, Button lancerDe, int[] diceImages, ImageView dice){
		this.joueurs = new Joueur[4];
		this.lon=longueur;
		this.lar=largueur;
		this.tour=3;
		this.next=next;
		this.lancerDe=lancerDe;
		this.diceImages=diceImages;
		this.dice=dice;
	}

	public void init(Button buttonJoueurs [][]){
		Button[] tab =new Button[4];
		for(int i = 1; i <= 4; i ++) {
			for (int j=0;j<4;j++) {
				tab[j]=buttonJoueurs[i-1][j];
			}
			int tmp = 13 * (i - 1);
			joueurs[i-1] = new Joueur(i, tmp, tab, this.lon, this.lar);
		}
		this.next.setEnabled(true);
		this.next.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				jouer();
			}

		});
	}

	/**
	 * Méthode permettant de lancer le jeu.
	 */
	public void jouer() {
		this.desactiverNext();
		for (Joueur j : joueurs) {
			for (Pion p : j.getPions()) {
				if (p.getPos() == -1) {
					p.bouttonSetPositionDeb(this.lon, this.lar);
				} else {
					p.moveBouton(this.lon, this.lar, posX[p.getPos()], posY[p.getPos()]);
				}
				p.setSelected(false);
				p.setMove(0);
			}
		}
		this.up();
		Joueur j = joueurs[this.getTour()];
		for (Pion p : j.getPions()) {
			if(p.getPos()!=-2)
			p.setSelected(true);
		}
		this.lancerDe();
	}
	public void tour(){
		Joueur j = joueurs[this.getTour()];
		this.desactiverDe();

		Random r = new Random();

		int tir = r.nextInt(5)+1;
		updateImageDe(tir);
		if(j.getWin() == 0){
			for (Pion p : j.getPions()) {
				// Si le pion est dans la réserve et que le dé n'est pas à 6.
				/*if (p.inReserve() && ((this.tirage) != 6))
					p.setSelected(false);

					// Si le pion est à la fin du parcours et que le dé produit un dépassement.
				else if (p.inEndParcours() && p.getPos() + (this.tirage) >= -1)
					p.setSelected(false);
				else {*/
				/*if (tir == 6) {
					p.setMove(tir);
				}*/
			}
			//}
			this.activeNext();
		}else{
			this.jouer();
		}
	}

	/**
	 * Méthode permettant de mettre la position du joueur sur le podium s'il a gagné.
	 *
	 * @param j
	 * 		Le joueur à analiser.
	 */
	public void victoire(Joueur j){

		// Si le joueur a terminé.
		if(j.isVictoire()){
			int sup = 0;
			// On met la prochaine position du podium.
			for(Joueur j1 : joueurs){
				if(j1.getWin() > sup){
					sup = j1.getWin();
				}
			}
			j.setWin(sup+1);
		}
	}

	/**
	 * Méthode permettant de savoir si tous les joueurs ont fini la partie.
	 *
	 * @return
	 * 		True si la partie est terminée, false sinon.
	 */
	public void allVictoire(){
		for(Joueur j : joueurs){
			if(j.getWin() == 0){
			}
			if(j.getWin() == 4){
				this.next.setEnabled(false);
			}
		}
	}

	public void up(){
		this.tour=((this.tour+1)%4);

	}

	public int getTour(){
		return this.tour;
	}

	public void lancerDe(){
		this.lancerDe.setEnabled(true);
		this.lancerDe.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				tour();
			}
		});
	}

	private void desactiverDe(){
		lancerDe.setEnabled(false);
	}
	public void desactiverNext(){
		this.next.setEnabled(false);
	}
	public void activeNext(){
		this.next.setEnabled(true);
	}
	public void updateImageDe(int number){
		dice.setImageResource(diceImages[number]);
	}
}
