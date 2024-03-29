package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	ControlVerifierIdentite control;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 10);
		Gaulois obelix = new Gaulois("Obélix", 5);
		village.ajouterHabitant(obelix);
		Chef chef = new Chef("chef", 10, village);
		village.setChef(chef);
		control = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(control);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(control.verifierIdentite("Obélix"));
		assertTrue(control.verifierIdentite("chef"));
		assertFalse(control.verifierIdentite("Panoramix"));
	}

}
