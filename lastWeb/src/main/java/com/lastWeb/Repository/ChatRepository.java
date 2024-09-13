package com.lastWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lastWeb.Entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{
}
