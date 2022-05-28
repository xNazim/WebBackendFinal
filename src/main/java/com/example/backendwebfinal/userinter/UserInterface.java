package com.example.backendwebfinal.userinter;

import com.example.backendwebfinal.user.UserReg;
import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<UserReg, Long> {
}
