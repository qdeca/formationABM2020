package fr.abm.quiz_manager.dataservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.abm.quiz_manager.entity.Topic;

public class TopicDAO extends AbstractDAO<Topic> {

	@Override
	public void create(Topic topic) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("INSERT INTO TOPIC(NAME) VALUES(?)");
			statement.setString(1, topic.getName());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public Topic getTopicById(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM TOPIC WHERE ID=?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			String name = resultSet.getString(2);
			Topic topic = new Topic(id, name);
			return topic;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Topic getTopicByName(String name) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM TOPIC WHERE NAME=?");
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int id = resultSet.getInt(1);
			Topic topic = new Topic(id, name);
			return topic;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void update(Topic topic) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("UPDATE TOPIC SET NAME=? WHERE ID=?");
			statement.setString(1, topic.getName());
			statement.setInt(2, topic.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Topic topic) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("DELETE FROM TOPIC WHERE ID=?");
			statement.setInt(1, topic.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteByName(String topicName) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("DELETE FROM TOPIC WHERE NAME=?");
			statement.setString(1, topicName);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
