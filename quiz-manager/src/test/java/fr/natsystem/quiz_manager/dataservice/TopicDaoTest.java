package fr.natsystem.quiz_manager.dataservice;

import org.junit.Assert;
import org.junit.Test;

import fr.abm.quiz_manager.dataservice.TopicDAO;
import fr.abm.quiz_manager.entity.Topic;

public class TopicDaoTest {
	
	TopicDAO topicDAO = new TopicDAO();
	
	@Test
	public void testTopic() {
		Topic topic = new Topic("Java");
		topicDAO.create(topic);
		Topic topicFromDB = topicDAO.getTopicByName("Java");
		Assert.assertNotNull(topicFromDB);
		topicDAO.deleteByName("Java");
	}
	
	@Test
	public void testReadingTopic() {
		Topic topic = new Topic("Java");
		topicDAO.create(topic);
		Topic topicFromDB = topicDAO.getTopicByName("Java");
		Assert.assertNotNull(topicFromDB);
		topicDAO.deleteByName("Java");
	}


}
