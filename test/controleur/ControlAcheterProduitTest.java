package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	
	ControlAcheterProduit control;
	ControlVerifierIdentite controlVerifierIdentite;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village de test", 10, 10);
		Chef chef = new Chef("Abra", 10, village);
		village.setChef(chef);
		Gaulois obelix = new Gaulois("Obélix", 5);
		Druide pano = new Druide("Pano", 5, 8, 10);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(pano);
		village.installerVendeur(obelix, "fleurs", 10);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		control = new ControlAcheterProduit( controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(control);
	}

	@Test
	void testRechercherVendeursProduit() {
		String[] expected = null;
		String[] actual = control.rechercherVendeursProduit("pain");
		assertArrayEquals(expected, actual);
		String[] expected1 = {"Obélix"};
		String[] actual1 = control.rechercherVendeursProduit("fleurs");
		assertArrayEquals(expected, actual);
	}

	@Test
	void testAcheterProduit() {
		assertEquals(6, control.acheterProduit("Obélix", 6));
		assertEquals(4, control.acheterProduit("Obélix", 6));
	}

}
