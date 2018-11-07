package edu.depaul.cdm.se.SpaceApplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Members, String> {

}
