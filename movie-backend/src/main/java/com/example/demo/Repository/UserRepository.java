<<<<<<< HEAD
package com.example.demo.Repository;

import java.util.Optional;

//import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

}
=======
package com.example.demo.Repository;

import java.util.Optional;

//import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

}
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
