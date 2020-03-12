/**
 * Représente un pion avec un son numéro unique composé du num du joueur et	du num du pion.
 *
 * @author Emeric Mottier
 * @version 1.1
 */
package com.example.projet;
import android.view.View;
import android.widget.Button;

public class Pion {
	/**
	 * La position du pion sur le plateau (les positions négatives correspondent
	 * aux cases du joueur, -1 la réserve, -2 l'arrivée, -3 la case juste avant
	 * l'arrivée, etc).
	 */
	private int pos;

	/**
	 * Le numéro du pion, non unique sur le plateau, dépend du joueur.
	 */
	private int numPion;

	/**
	 * Le numéro du joueur à qui appartient le pion.
	 */
	private int numJoueur;

	/**
	 * Permet de savoir si le pion est séléctionné ou non.
	 */
	private boolean isSelected;

	private Button bouton;

	public int move;

	private int position;

	/**
	 * Constructeur
	 *
	 * @param pos
	 * 		Position du pion sur le plateau.
	 * @param numPion
	 * 		Numéro du pion.
	 * @param numJoueur
	 * 		Numéro du joueur liée au pion.
	 */
	public Pion(int pos, int numPion, int numJoueur, Button b){
		this.pos = pos;
		this.numPion = numPion;
		this.numJoueur = numJoueur;
		this.move=0;
		this.bouton=b;
		this.isSelected=false;
	}

	/**
	 * Accesseur permettant de savoir si le pion est sélectionnée.
	 *
	 * @return
	 * 		True si le pion est sélectionné, false sinon.
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * Mutateur permettant de modifier la séléction du pion.
	 *
	 * @param selected
	 * 		True si le pion doit être sélectionné, false sinon.
	 */
	public void setSelected(boolean selected) {
		isSelected = selected;
		this.bouton.setEnabled(isSelected);
		this.bouton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				setPos();
			}

		});
	}

	/**
	 * Accesseur permettant de renvoyer true si le pion est dans la réserve, false sinon.
	 *
	 * @return
	 * 		True si le pion est dans la réserve, false sinon.
	 */
	public boolean inReserve(){
		return pos == -1;
	}

	/**
	 * Accesseur permettant de savoir si le pion est dans la fin du parcours.
	 *
	 * @return
	 * 		True si le pion est dans la fin du parcours, false sinon.
	 */
	public boolean inEndParcours(){
		return pos < 0 && pos != -1;
	}

	/**
	 * Accesseur permettant de renvoyer la position du pion.
	 *
	 * @return
	 * 		La position du pion.
	 */
	public int getPos() {
		return pos;
	}

	public void bouttonSetPositionDeb(int lon, int lar) {

		if (this.numJoueur == 1) {
			if (this.numPion == 1) {
				this.bouton.setX((float) (lon / 2 - lar * 6 / 16));
				this.bouton.setY((float) (lar / 2 + lar * 5 / 16));
			}
			if (this.numPion == 2) {
				this.bouton.setX((float) (lon / 2 - lar * 6 / 16));
				this.bouton.setY((float) (lar / 2 + lar * 3 / 16));
			}
			if (this.numPion == 3) {
				this.bouton.setX((float) (lon / 2 - lar * 4 / 16));
				this.bouton.setY((float) (lar / 2 + lar * 3 / 16));
			}
			if (this.numPion == 4) {
				this.bouton.setX((float) (lon / 2 - lar * 4 / 16));
				this.bouton.setY((float) (lar / 2 + lar * 5 / 16));
			}
		}
			if (this.numJoueur == 2) {
				if (this.numPion == 1) {
					this.bouton.setX((float) (lon / 2 - lar * 6 / 15));
					this.bouton.setY((float) (lar / 2 - lar * 6 / 16));
				}
				if (this.numPion == 2) {
					this.bouton.setX((float) (lon / 2 - lar * 6 / 15));
					this.bouton.setY((float) (lar / 2 - lar * 4 / 16));
				}
				if (this.numPion == 3) {
					this.bouton.setX((float) (lon / 2 - lar * 4 / 15));
					this.bouton.setY((float) (lar / 2 - lar * 4 / 16));
				}
				if (this.numPion == 4) {
					this.bouton.setX((float) (lon / 2 - lar * 4 / 15));
					this.bouton.setY((float) (lar / 2 - lar * 6 / 16));
				}
			}
			if (this.numJoueur == 3) {
				if (this.numPion == 1) {
					this.bouton.setX((float) (lon / 2 + lar * 7 / 16));
					this.bouton.setY((float) (lar / 2 - lar * 6 / 16));
				}
				if (this.numPion == 2) {
					this.bouton.setX((float) (lon / 2 + lar * 7 / 16));
					this.bouton.setY((float) (lar / 2 - lar * 4 / 16));
				}
				if (this.numPion == 3) {
					this.bouton.setX((float) (lon / 2 + lar * 5/ 16));
					this.bouton.setY((float) (lar / 2 - lar * 4 / 16));
				}
				if (this.numPion == 4) {
					this.bouton.setX((float) (lon / 2 + lar * 5 / 16));
					this.bouton.setY((float) (lar / 2 - lar * 6 / 16));
				}
			}
			if (this.numJoueur == 4) {
				if (this.numPion == 1) {
					this.bouton.setX((float) (lon / 2 + lar * 7 / 16));
					this.bouton.setY((float) (lar / 2 + lar * 5 / 16));
				}
				if (this.numPion == 2) {
					this.bouton.setX((float) (lon / 2 + lar * 7 / 16));
					this.bouton.setY((float) (lar / 2 + lar * 3 / 16));
				}
				if (this.numPion == 3) {
					this.bouton.setX((float) (lon / 2 + lar * 5 / 16));
					this.bouton.setY((float) (lar / 2 + lar * 3 / 16));
				}
				if (this.numPion == 4) {
					this.bouton.setX((float) (lon / 2 + lar * 5 / 16));
					this.bouton.setY((float) (lar / 2 + lar * 5 / 16));
				}
			}
	}

	/**
	 * Mutateur permettant de modifier la position du joueur.
	 *
	 * @param pos
	 * 		La nouvelle position du joueur.
	 */
	public void setPos(int pos){
		this.pos = pos;
	}

	public void moveBouton (int lon , int lar , int x, int y){
		this.bouton.setX((float) (lon / 2 + lar * x / 16));
		this.bouton.setY((float) (lar / 2 + lar * y / 16));
	}

	/**
	 * Accesseur permettant de retourner le numéro du joueur liée au pion.
	 *
	 * @return
	 * 		Le numéro du joueur.
	 */
	public int getNumJoueur() {
		return numJoueur;
	}

	/**
	 * Accesseur permettant de renvoyer le numéro du pion.
	 *
	 * @return
	 * 		Le numéro du pion.
	 */
	public int getNumPion() {
		return numPion;
	}

	public void setPos(){
		pos=pos+move;
	}

	public int getMove(){
		return this.move;
	}

	public void setMove(int x){
		this.move=x;
	}

}
