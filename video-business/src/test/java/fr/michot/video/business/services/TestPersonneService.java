package fr.michot.video.business.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.michot.video.business.services.impl.PersonneServiceImpl;
import fr.michot.video.db.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
public class TestPersonneService {

	@Autowired
	PersonneServiceImpl pService;

	@Test
	public void testCreate() {
		Personne unePersonne = pService.ajoute("testnom", "testprenom", Boolean.TRUE, Boolean.TRUE, null, null);
		Assert.assertNotNull(unePersonne);
	}

	@Test
	public void testRecherche() {
		Personne unePersonne = pService.ajoute("testnom", "testprenom", Boolean.TRUE, Boolean.TRUE, null, null);
		List<Personne> listePersonnes = pService.recherche("test", "", null, null);
		Assert.assertNotNull(unePersonne);
		Assert.assertNotNull(listePersonnes);
		Assert.assertTrue(!listePersonnes.isEmpty());
	}

}
