package com.developer.SpringMySQL.daos;

import com.developer.SpringMySQL.models.AppUsers;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pukar on 6/25/2017.
 */
public interface AppUsersRepo extends CrudRepository<AppUsers,Integer>{
}
