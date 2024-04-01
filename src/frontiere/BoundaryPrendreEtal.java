package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean etalDisponible;
		
		if (!(controlPrendreEtal.verifierIdentite(nomVendeur))) {
			System.out
			.println("Je suis désolé " + nomVendeur + " mais il faut être un "
					+ "habitant de notre village pour commercer ici\n");
		} else {
			System.out
			.println("Bonjour " + nomVendeur + " ,je vais regarder si je peux vous trouver un étal.\n");
			etalDisponible = controlPrendreEtal.resteEtals();
			
			if (!(etalDisponible)) {
				System.out
				.println("Désolé " + nomVendeur + "je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
				
			} else {
				installerVendeur(nomVendeur);
				
			}
			
		}
	}

	private void installerVendeur(String nomVendeur) {
		
		StringBuilder chaine = new StringBuilder();
		chaine.append("C'est parfait, il me reste un étal pour vous !\n");
		chaine.append("Il me faudrait quelques renseignements :\n");
		chaine.append("Quel produit souhaitez-vous vendre ?");
		System.out.println(chaine.toString());
		String produit = scan.next();
		
		StringBuilder question = new StringBuilder();
		question.append("Combien souhaitez-vous en vendre ?");
		int nbProduit = Clavier.entrerEntier(question.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if (numeroEtal != -1) {
			System.out
				.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal);
		}
	}
}
