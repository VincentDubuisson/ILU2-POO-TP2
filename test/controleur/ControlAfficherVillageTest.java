package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	ControlAfficherVillage control;
	ControlEmmenager controlEmmenager;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 10);
		control = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(control);
	}

	@Test
	void testDonnerNomsVillageois() {
		/*controlEmmenager.ajouterGaulois("Asterix", 2);
		controlEmmenager.ajouterGaulois("Obélix", 3);*/
		//assertarrayequals
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(control.donnerNomVillage(), "Village de test");
		assertNotEquals(control.donnerNomVillage(), "Test");
	}

	@Test
	void testDonnerNbEtals() {
		//assertEquals(0, control.donnerNbEtals());
		//assertFalse(control.donnerNbEtals() == 5);
	}

}
