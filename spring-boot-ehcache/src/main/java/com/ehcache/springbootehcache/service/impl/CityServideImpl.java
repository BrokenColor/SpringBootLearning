package com.ehcache.springbootehcache.service.impl;

import com.ehcache.springbootehcache.dao.CityRepository;
import com.ehcache.springbootehcache.pojo.City;
import com.ehcache.springbootehcache.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: GWL
 * @Description: Service接口实现类
 * @Date: Create in 17:36 2019/5/10
 */
@Service
public class CityServideImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    @Cacheable(value="city")
    public List<City> findCityAll() {
        return this.cityRepository.findAll();
    }

    /**
     *  @Cacheable 使用缓存
     *      其中value表示该方法返回的参数的缓存存在那个Cache里(即为缓存块的名字)
     *      缓存结果以一个键值对存放在缓存中,注解中key即为键值对的key;value即为方法返回的结果
     *      key用双引号,里面#加上方法的参数:获取方法的参数,  ''表示在参数之间添加分隔符
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "city")
    public City findCityById(Integer id) {
        return this.cityRepository.findById(id).get();
    }

    /**
     * #pageable.pageSize为缓存主键
     * @param pageable
     * @return
     */
    @Override
    @Cacheable(value = "city",key = "#pageable.pageSize")
    public Page<City> findCityByPage(Pageable pageable) {
        return this.cityRepository.findAll(pageable);
    }

    @Override
    //@CacheEvict(value="city",allEntries=true) 清除缓存中以city缓存策略缓存的对象
    @CacheEvict(value="city",allEntries=true)
    public void saveCity(City city) {
        this.cityRepository.save(city);
    }
}
