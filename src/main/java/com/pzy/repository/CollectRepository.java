package com.pzy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Collect;
import com.pzy.entity.Resource;
import com.pzy.entity.User;
public interface CollectRepository extends PagingAndSortingRepository<Collect, Long>,JpaSpecificationExecutor<Collect>{
public List<Collect> findByUser(User user);
public List<Collect> findByUserAndResource(User user,Resource resource);
}

