package xyz.mrwood.study.spring.mybatis.dao;

import java.util.HashMap;
import java.util.List;

public interface OrderMapperExt extends OrderMapper {

    Integer addList(List<HashMap<String, Object>> list);

}
