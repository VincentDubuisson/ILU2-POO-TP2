package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] rechercherVendeursProduit(String produit) {
		Gaulois[] vendeursGaulois = village.rechercherVendeursProduit(produit);
		String[] vendeurs = null;
		if (vendeursGaulois != null) {
			vendeurs = new String[vendeursGaulois.length];
			for (int i = 0; i < vendeursGaulois.length; i++) {
				vendeurs[i] = vendeursGaulois[i].getNom();
			}
		}
		return vendeurs;
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		Etal etalVendeur = village.rechercherEtal(vendeur);
		return etalVendeur.acheterProduit(quantite);
	}
}
