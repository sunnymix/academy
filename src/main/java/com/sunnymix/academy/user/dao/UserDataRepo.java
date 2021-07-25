package com.sunnymix.academy.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepo extends JpaRepository<UserData, Long> {
}
