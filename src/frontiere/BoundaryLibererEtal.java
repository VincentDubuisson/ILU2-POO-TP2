package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!(controlLibererEtal.isVendeur(nomVendeur))) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");

		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			
			if (Boolean.valueOf(donneesEtal[0])) {
				StringBuilder donnees = new StringBuilder();
				donnees.append("Vous avez vendu " + donneesEtal[4]);
				donnees.append(" sur " + donneesEtal[3] + " ");
				donnees.append(donneesEtal[2] + ".\n");
				donnees.append("En revoir " + nomVendeur + ", passez une bonne journée.");
				System.out.println(donnees.toString());
			}
		}
	}

}
