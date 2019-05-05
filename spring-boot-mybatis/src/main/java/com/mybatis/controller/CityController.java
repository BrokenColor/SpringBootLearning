package com.mybatis.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybatis.domain.City;
import com.mybatis.domain.JsonResult;
import com.mybatis.service.CityService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author BrokenColor
 * @data 2018年5月24日
 */
@Controller
@RequestMapping("/citys")
public class CityController {
	
	@Resource
	CityService cityService;

    @ApiOperation(value="获取城市列表", notes="")
    @RequestMapping(value={"/getCityList"}, method=RequestMethod.GET)
    public ResponseEntity<JsonResult> getCityList (){
		JsonResult r = new JsonResult();
		try {
			List<City> citys = cityService.getCityList();
			r.setResult(citys);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

    /*
     * 我们通过@ApiOperation注解来给API增加说明、
     * 通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明。
     * 
     */
    @ApiOperation(value="创建", notes="根据City对象创建")
    @ApiImplicitParam(name = "city", value = "详细实体city", required = true, dataType = "City")
    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody City city){
		JsonResult r = new JsonResult();
		try {
			int orderId = cityService.add(city);
			if (orderId < 0) {
				r.setResult(orderId);
				r.setStatus("fail");
			} else {
				r.setResult(orderId);
				r.setStatus("ok");
			}
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");

			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

    @ApiOperation(value="获取city详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value = "city/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserById (@PathVariable Long id){
		JsonResult r = new JsonResult();
		try {
			City city = cityService.getCityById(id);
			r.setResult(city);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

    @ApiOperation(value="更新city详细信息", notes="根据url的id来指定更新对象，并根据传过来的city信息来更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "cityID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "city", value = "详细实体city", required = true, dataType = "City")
    })
    @RequestMapping(value = "city/{id}", method = RequestMethod.PUT)
	public ResponseEntity<JsonResult> update (@PathVariable("id") Long id, @RequestBody City city){
		JsonResult r = new JsonResult();
		try {
			int ret = cityService.update(id, city);
			if (ret < 0) {
				r.setResult(ret);
				r.setStatus("fail");
			} else {
				r.setResult(ret);
				r.setStatus("ok");
			}
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");

			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

    @ApiOperation(value="删除city", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "cityID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value = "city/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<JsonResult> delete (@PathVariable(value = "id") Long id){
		JsonResult r = new JsonResult();
		try {
			int ret = cityService.delete(id);
			if (ret < 0) {
				r.setResult(ret);
				r.setStatus("fail");
			} else {
				r.setResult(ret);
				r.setStatus("ok");
			}
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");

			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
}
