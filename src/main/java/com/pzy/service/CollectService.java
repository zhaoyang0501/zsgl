
package com.pzy.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pzy.entity.Category;
import com.pzy.entity.Collect;
import com.pzy.entity.Resource;
import com.pzy.entity.User;
import com.pzy.repository.CollectRepository;

@Service
public class CollectService {
     @Autowired
     private CollectRepository collectRepository;
     
     public Collect save(Collect collect){
    	 return  this.collectRepository.save(collect);
     }
     public void delete(Collect collect){
    	this.collectRepository.delete(collect);
     }
     public List<Collect> findByUser(User user){
    	 return this.collectRepository.findByUser(user);
     }
     public List<Collect> findByUserAndCookBook(User user,Resource resource){
    	 return this.collectRepository.findByUserAndResource(user, resource);
     }
     public Page<Collect> findAll(final int pageNumber, final int pageSize,final String keyword){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Specification<Collect> spec = new Specification<Collect>() {
              @Override
              public Predicate toPredicate(Root<Collect> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (keyword != null) {
                 predicate.getExpressions().add(cb.like(root.get("resource").get("keyword").as(String.class), "%"+keyword+"%"));
              }
              return predicate;
              }
         };
         Page<Collect> result = (Page<Collect>) collectRepository.findAll(spec, pageRequest);
         return result;
     }
}