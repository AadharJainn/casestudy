package ct.dp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ct.dp.entity.PizzaOrderEntity;

@Repository
public interface PizzaOrderDao extends JpaRepository<PizzaOrderEntity, Integer> 
{
 @Query(name="PizzaOrderEntity.saveAllPizzaDetails")
 public	PizzaOrderEntity save();
	
	
	
}
