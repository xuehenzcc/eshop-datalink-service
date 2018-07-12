/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月10日
 */
package com.zcc.datalink_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zcc.datalink_server.service.ProductService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author c0z00k8
 *
 */
@Controller
public class DataLinkController {

	@Autowired
	private ProductService eshopProductService;
	@Autowired
	private JedisPool jedisPool;
	
	@RequestMapping("/getProduct")
	@ResponseBody
	public String getProduct(Long productId) {
		// 先读本地的ehcache，但是我们这里就不做了，因为之前都演示过了，大家自己做就可以了
		
		// 读redis主集群
		Jedis jedis = jedisPool.getResource();
		String dimProductJSON = jedis.get("dim_product_" + productId);
		
		if(dimProductJSON == null || "".equals(dimProductJSON)) {
	    	String productDataJSON = eshopProductService.findProductById(productId);
	    	
	    	if(productDataJSON != null && !"".equals(productDataJSON)) {
	    		JSONObject productDataJSONObject = JSONObject.parseObject(productDataJSON);
	    		
	    		String productPropertyDataJSON = eshopProductService.findProductPropertyByProductId(productId);
	    		if(productPropertyDataJSON != null && !"".equals(productPropertyDataJSON)) {
	    			productDataJSONObject.put("product_property", JSONObject.parse(productPropertyDataJSON));
	    		} 
	    		
	    		String productSpecificationDataJSON = eshopProductService.findProductSpecificationByProductId(productId);
	    		if(productSpecificationDataJSON != null && !"".equals(productSpecificationDataJSON)) {
	    			productDataJSONObject.put("product_specification", JSONObject.parse(productSpecificationDataJSON));
	    		}
	    		
	    		jedis.set("dim_product_" + productId, productDataJSONObject.toJSONString());
	    		
	    		return productDataJSONObject.toJSONString();
	    	} 
		}else{
			return dimProductJSON;
		}
		
		return "no data";
	}
	
	@RequestMapping("/getBrand")
	@ResponseBody
	public String getBrand(Long id) {
		// 先读本地的ehcache，但是我们这里就不做了，因为之前都演示过了，大家自己做就可以了
		
		// 读redis主集群
		Jedis jedis = jedisPool.getResource();
		String brandJSON = jedis.get("brand_" + id);
		
		if(brandJSON == null || "".equals(brandJSON)) {
	    	String brandDataJSON = eshopProductService.findBrandById(id);
	    	
	    	if(brandDataJSON != null && !"".equals(brandDataJSON)) {
	    		jedis.set("brand_" + id, brandDataJSON);
	    		return brandDataJSON;
	    	} 
		}else{
			return brandJSON;
		}
		
		return "no data";
	}
	
}
