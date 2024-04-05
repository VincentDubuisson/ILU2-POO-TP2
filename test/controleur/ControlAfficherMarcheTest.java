package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
	ControlAfficherMarche control;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	ControlPrendreEtal controlPrendreEtal;
	ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 2);
		Gaulois obelix = new Gaulois("Obélix", 5);
		Gaulois asterix = new Gaulois("Astérix", 3);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);
		Chef chef = new Chef("chef", 10, village);
		village.setChef(chef);
		
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		control = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(control);
	}

	@Test
	void testDonnerInfosMarche() {
		controlPrendreEtal.prendreEtal("Obélix", "fleurs", 10);
		String[] expected = {"Obélix", "10", "fleurs"};
		String[] actual = control.donnerInfosMarche();
		assertArrayEquals(expected, actual);
	}

}
