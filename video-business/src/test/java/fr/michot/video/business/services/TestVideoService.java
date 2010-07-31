package fr.michot.video.business.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.michot.video.business.services.impl.FilmServiceImpl;
import fr.michot.video.db.Film;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
public class TestVideoService {

	@PersistenceContext
	EntityManager em;

	@Autowired
	FilmServiceImpl fService;

	@Test
	public void testCreation() {
		Film unFilm1 = fService.enregistrerNouveau("TheMovie1", "resume1",
				"imageUrl1", null, null);
		Film unFilm2 = fService.enregistrerNouveau("TheMovie2", "resume2",
				"imageUrl2S", null, null);
		Assert.assertTrue(unFilm2.getId() != unFilm1.getId());
	}

}
