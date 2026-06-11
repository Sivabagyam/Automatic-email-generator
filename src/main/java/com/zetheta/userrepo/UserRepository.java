package com.zetheta.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zetheta.usermodel.Users;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{

}
