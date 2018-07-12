/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月10日
 */
package com.zcc.datalink_server.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zcc.datalink_server.service.fallback.ProductServiceFallback;

/**
 * @author c0z00k8
 *
 */
@FeignClient(value="eshop-product-service",fallback=ProductServiceFallback.class)
public interface ProductService {

	@RequestMapping(value = "/brand/findById",method = RequestMethod.GET)
    String findBrandById(@RequestParam(value = "id") Long id);
    
    @RequestMapping(value = "/brand/findByIds",method = RequestMethod.GET)
    String findBrandByIds(@RequestParam(value = "ids") String ids);
    
    @RequestMapping(value = "/category/findById",method = RequestMethod.GET)
    String findCategoryById(@RequestParam(value = "id") Long id);
    
    @RequestMapping(value = "/product-intro/findById",method = RequestMethod.GET)
    String findProductIntroById(@RequestParam(value = "id") Long id);
    
    @RequestMapping(value = "/product-property/findById",method = RequestMethod.GET)
    String findProductPropertyById(@RequestParam(value = "id") Long id);
    
    @RequestMapping(value = "/product-property/findByProductId",method = RequestMethod.GET)
    String findProductPropertyByProductId(@RequestParam(value = "productId") Long productId);
    
    @RequestMapping(value = "/product/findById",method = RequestMethod.GET)
    String findProductById(@RequestParam(value = "id") Long id);
    
    @RequestMapping(value = "/product-specification/findById",method = RequestMethod.GET)
    String findProductSpecificationById(@RequestParam(value = "id") Long id);
    
    @RequestMapping(value = "/product-specification/findByProductId",method = RequestMethod.GET)
    String findProductSpecificationByProductId(@RequestParam(value = "productId") Long productId);
}
