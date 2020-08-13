package com.multidruid.demo.mapper.orderdb;

import com.multidruid.demo.pojo.Goods;
import com.multidruid.demo.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper {
    Order selectOneOrder(Long orderId);
}
