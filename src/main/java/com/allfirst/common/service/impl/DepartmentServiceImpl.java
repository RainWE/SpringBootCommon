package com.allfirst.common.service.impl;

import com.allfirst.common.dao.DepartmentDao;
import com.allfirst.common.domain.Department;
import com.allfirst.common.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;
    //deptCacheManager命名是以MyRedisConfig.java中public RedisCacheManager deptCacheManager(...)决定
    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;


    /**使用@Cacheable将数据存入redis
     *  缓存的数据能存入redis；
     *  第二次从缓存中查询就不能反序列化回来；
     *  存的是dept的json数据;CacheManager默认使用RedisTemplate<Object, Employee>操作Redis
     *
     *  spring的cache使用redis进行缓存，相结合
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "dept",cacheManager = "deptCacheManager")
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentDao.getDeptById(id);
        return department;
    }
/*
    // 使用缓存管理器得到缓存，进行api调用
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentDao.getDeptById(id);

        //获取某个缓存
        Cache dept = deptCacheManager.getCache("dept");
        dept.put("dept:1",department);

        return department;
    }
*/
}
