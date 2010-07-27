package fr.michot.video.business.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
public class TestVideoService {

	@PersistenceContext
	EntityManager em;
	
	@Test
	@Transactional
	public void testCreation() {
	
	}
}
