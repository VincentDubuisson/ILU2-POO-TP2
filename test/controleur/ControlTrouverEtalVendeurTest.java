package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	ControlTrouverEtalVendeur  control;
	ControlPrendreEtal controlPrendreEtal;
	ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 1);
		Gaulois obelix = new Gaulois("Obélix", 5);
		Gaulois asterix = new Gaulois("Astérix", 3);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);
		Chef chef = new Chef("chef", 10, village);
		village.setChef(chef);
		
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		control = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(control);
	}

	@Test
	void testTrouverEtalVendeur() {
		assertEquals(null, control.trouverEtalVendeur("Obélix"));
		assertEquals(null, control.trouverEtalVendeur(""));
		controlPrendreEtal.prendreEtal("Astérix", "fleurs", 10);
	}

}
