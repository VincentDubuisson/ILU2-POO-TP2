package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	ControlPrendreEtal control;
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
		control = new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(control);
	}

	@Test
	void testResteEtals() {
		control.prendreEtal("Obélix", "fleurs", 10);
		assertFalse(control.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		assertEquals(1, control.prendreEtal("Obélix", "fleurs", 10));
		//assertEquals(-1, control.prendreEtal("chef", "pierre", 20));
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(control.verifierIdentite("chef"));
		assertTrue(control.verifierIdentite("Obélix"));
		assertFalse(control.verifierIdentite("Panoramix"));
	}

}
