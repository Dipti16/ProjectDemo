package com.example.ProjectDemoExample.Dao;

import com.example.ProjectDemoExample.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepo extends JpaRepository<Book,Long>
{
}
