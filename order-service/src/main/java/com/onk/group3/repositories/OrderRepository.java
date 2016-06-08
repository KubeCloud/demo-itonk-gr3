package com.onk.group3.repositories;

import com.onk.group3.models.XOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lars on 18-04-2016.
 */
public interface OrderRepository extends CrudRepository<XOrder, Long> {
/* Long[] findByCustomer(Long customerId); */
}
