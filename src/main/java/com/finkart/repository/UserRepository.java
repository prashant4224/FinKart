package com.finkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finkart.entity.User;

/**
 * @author PRASHANT
 * 
 * The Interface CustomerRepository.
 */

/**
 * Without @Repository - Spring Data repositories usually extend from the
 * Repository or CrudRepository interfaces. If you are using auto-configuration,
 * repositories will be searched from the package containing your main
 * configuration class (the one annotated with @EnableAutoConfiguration
 * or @SpringBootApplication) down.
 * 
 * It is indeed not necessary to put the @Repository annotation on interfaces
 * that extend JpaRepository; Spring recognises the repositories by the fact
 * that they extend one of the predefined Repository interfaces.
 * 
 * The purpose of the @NoRepositoryBean annotation is to prevent Spring from
 * treating that specific interface as a repository by itself. The JpaRepository
 * interface has this annotation because it isn't a repository itself, it's
 * meant to be extended by your own repository interfaces, and those are the
 * ones that should be picked up.
 */
public interface UserRepository extends JpaRepository<User, Long> {

//	public User findByUsernameAndPassword(String username, String password);
}
