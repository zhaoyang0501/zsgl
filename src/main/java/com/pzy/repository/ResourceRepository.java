package com.pzy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Category;
import com.pzy.entity.Resource;
import com.pzy.entity.User;
public interface ResourceRepository extends PagingAndSortingRepository<Resource, Long>,JpaSpecificationExecutor<Resource>{
	public List<Resource> findByCreaterOrderByCreateDateDesc(User user);
	public List<Resource> findByCategory(Category user);
}

