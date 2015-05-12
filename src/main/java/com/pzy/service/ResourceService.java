
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
import com.pzy.entity.Resource;
import com.pzy.entity.User;
import com.pzy.repository.CategoryRepository;
import com.pzy.repository.ResourceRepository;

@Service
public class ResourceService {
     @Autowired
     private ResourceRepository resourceRepository;
     @Autowired
     private CategoryRepository categoryRepository;
    
     public void delete(Long id){
    	 resourceRepository.delete(id);
     }
     public Resource find(Long id){
    	  return resourceRepository.findOne(id);
     }
     public List<Resource> find(User user){
   	  return resourceRepository.findByCreaterOrderByCreateDateDesc(user);
     }
     public void save(Resource resource){
    	 resourceRepository.save(resource);
     }
     public List<Resource> findAll(){
      	  return (List<Resource>) resourceRepository.findAll();
     }
     public List<Resource> find(Category category){
     	  return (List<Resource>) resourceRepository.findByCategory(category);
     }
     /***
      * 查找浏览最多的记录
      * @return
      */
     public List<Resource> findHot(){
    	  return resourceRepository.findAll( new PageRequest(0, 8, new Sort(Direction.DESC, "count"))).getContent();
     }
     /***
      * 查找最新上传的记录
      * @return
      */
     public List<Resource> findNew(){
    	  return resourceRepository.findAll( new PageRequest(0, 8, new Sort(Direction.DESC, "createDate"))).getContent();
     }
     public Page<Resource> findAll(final int pageNumber, final int pageSize,final String name,final Long categoryId){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
        
         Specification<Resource> spec = new Specification<Resource>() {
              @Override
              public Predicate toPredicate(Root<Resource> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (name != null) {
                 predicate.getExpressions().add(cb.like(root.get("name").as(String.class), "%"+name+"%"));
              }
              if (categoryId!=null) {
          		predicate.getExpressions().add(cb.equal(root.get("category").as(Category.class), categoryRepository.findOne(categoryId)));
              }
              return predicate;
              }
         };
         Page<Resource> result = (Page<Resource>) resourceRepository.findAll(spec, pageRequest);
         return result;
}
}