package com.sickgyun.server.event.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.event.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
