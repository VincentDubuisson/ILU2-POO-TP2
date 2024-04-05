package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	ControlAfficherVillage control;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Abra", 10, village);
		village.setChef(chef);
		Gaulois obelix = new Gaulois("Obélix", 5);
		Gaulois asterix = new Gaulois("Astérix", 3);
		Druide pano = new Druide("Pano", 5, 8, 10);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(pano);
		control = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(control);
	}

	@Test
	void testDonnerNomsVillageois() {
		String[] expected = {"Abra", "Obélix", "Astérix", "le druide Pano"};
		String[] actual = control.donnerNomsVillageois();
		assertArrayEquals(expected, actual);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(control.donnerNomVillage(), "Village de test");
		assertNotEquals(control.donnerNomVillage(), "Test");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(10, control.donnerNbEtals());
	}

}
