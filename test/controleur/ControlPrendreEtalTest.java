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
		village.ajouterHabitant(obelix);
		Chef chef = new Chef("chef", 10, village);
		village.setChef(chef);
		village.installerVendeur(obelix, "fleurs", 10);
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
		//assertTrue(control.prendreEtal("Obélix", "fleurs", 10) == 1);
	}

	@Test
	void testVerifierIdentite() {
		//assertTrue(control.verifierIdentite("Obélix"));
		//assertFalse(control.verifierIdentite("Astérix"));
	}

}
