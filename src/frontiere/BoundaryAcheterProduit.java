package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import controleur.ControlVerifierIdentite;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
		
			System.out.println("Quel produit voulez-vous acheter ?\n");
			String produit = scan.next();
			
			String[] vendeursProduit = controlAcheterProduit.rechercherVendeursProduit(produit);
			if (vendeursProduit.length > 0) {
				StringBuilder question = new StringBuilder();
				question.append("Chez quel commerçant voulez-vous acheter des fleurs ?\n");
				
				for (int i = 0; i < vendeursProduit.length; i++) {
					question.append((i+1) + " - " + vendeursProduit[i] + "\n");
				}
				
				int numEtal = Clavier.entrerEntier(question.toString());
				
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " 
						+ vendeursProduit[numEtal - 1]);
				
				StringBuilder question1 = new StringBuilder();
				question1.append("Combien de " + produit + " voulez-vous acheter ?");
				int quantite = Clavier.entrerEntier(question1.toString());
				
				int quantiteAcheter = controlAcheterProduit.acheterProduit(vendeursProduit[numEtal - 1], quantite);
				
				System.out.println(nomAcheteur + " achète " + quantiteAcheter + " " + produit + " à " +
							vendeursProduit[numEtal - 1]);
				
				
			} else {
				System.out.println("Désolé, personne ne vend ce produit au marché.\n");
			}
		} else {
			System.out.println("Je suis désolé " + nomAcheteur +
					" mais il faut être un habitant de notre village pour commercer ici \n");
		}
		
		
		
	}
}
