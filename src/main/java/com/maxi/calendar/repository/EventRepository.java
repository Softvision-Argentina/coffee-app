package com.maxi.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxi.calendar.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	public Event findByName(String name);
}
