package fr.michot.video.business.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void testCreation() {
		Film unFilm = fService.enregistrerNouveau("TheMovie", "resume", "imageUrl", null,null );
		Film unFilm2 = fService.enregistrerNouveau("TheMovie2", "resume2", "imageUrl", null,null );
		Assert.assertTrue(unFilm2.getId()>0);
	}
}
