package com.sword.fighers.swordfighters.events;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwordEventRepository extends JpaRepository<SwordEvent, Integer>{
	List<SwordEvent> findSwordEventByAdminUserName(String adminUser);
}
