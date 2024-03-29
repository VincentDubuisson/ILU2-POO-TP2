package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	
	ControlEmmenager control;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("chef", 10, village);
		village.setChef(chef);
		control = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(control);
	}

	@Test
	void testIsHabitant() {
		control.ajouterGaulois("Asterix", 2);
		assertTrue(control.isHabitant("Asterix"));
		assertTrue(control.isHabitant("chef"));
		for (int i = 0; i < 10; i++) {
			control.ajouterGaulois("A" + i + 1, 2);
		}
		assertFalse(control.isHabitant("Obelix"));
	}

	@Test
	void testAjouterDruide() {
		control.ajouterDruide("Pano", 2, 5, 4);
		assertTrue(control.isHabitant("Pano"));
	}

	@Test
	void testAjouterGaulois() {
		control.ajouterGaulois("A0", 2);
		assertTrue(control.isHabitant("A0"));
	}

}
