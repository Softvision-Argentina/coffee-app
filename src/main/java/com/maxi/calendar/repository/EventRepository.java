package com.maxi.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maxi.calendar.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	public Event findByName(String name);
	
//	@Modifying
//	@Query(value="INSERT INTO usuario_evento (user_id, event_id) VALUES (:user_id, :event_id)")
//	public Event addUserToEvent(@Param("user_id") int userId, @Param("event_id") int eventId);
//	
//	@Query(value="DELETE FROM usuario_evento ue WHERE ue.user= ?1 ue.event= ?2")
//	public Event removeUserFromEvent(int userId, int eventId);
	
}
