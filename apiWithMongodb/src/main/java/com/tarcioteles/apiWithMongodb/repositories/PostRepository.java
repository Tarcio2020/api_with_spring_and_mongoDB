package com.tarcioteles.apiWithMongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tarcioteles.apiWithMongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
