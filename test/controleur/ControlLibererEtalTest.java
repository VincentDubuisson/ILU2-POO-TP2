package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
	ControlLibererEtal control;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
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
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		control = new ControlLibererEtal(controlTrouverEtalVendeur);
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(control);
	}

	@Test
	void testIsVendeur() {
		controlPrendreEtal.prendreEtal("Obélix", "fleurs", 10);
		assertTrue(control.isVendeur("Obélix"));
		assertFalse(control.isVendeur("Astérix"));
	}

	@Test
	void testLibererEtal() {
		controlPrendreEtal.prendreEtal("Obélix", "fleurs", 10);
		String[] expected = {"true", "Obélix", "fleurs", "10", "0"};
		String[] actual = control.libererEtal("Obélix");
		assertArrayEquals(expected, actual);
		expected = null;
		actual = control.libererEtal("Astérix");
		assertArrayEquals(expected, actual);
	}

}
