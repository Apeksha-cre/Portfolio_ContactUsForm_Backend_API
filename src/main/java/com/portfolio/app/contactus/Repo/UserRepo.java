package com.portfolio.app.contactus.Repo;

import com.portfolio.app.contactus.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long>
{

}
