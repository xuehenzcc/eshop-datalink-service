/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月10日
 */
package com.zcc.datalink_server.service.fallback;

import org.springframework.stereotype.Component;

import com.zcc.datalink_server.service.ProductService;

/**
 * @author c0z00k8
 *
 */
@Component
public class ProductServiceFallback implements ProductService{

	@Override
	public String findBrandById(Long id) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String findBrandByIds(String ids) {
		// TODO Auto-generated method stub
		return "fallback-error";
	}

	@Override
	public String findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return "fallback-error";
	}

	@Override
	public String findProductIntroById(Long id) {
		// TODO Auto-generated method stub
		return "fallback-error";
	}

	@Override
	public String findProductPropertyById(Long id) {
		// TODO Auto-generated method stub
		return "fallback-error";
	}

	@Override
	public String findProductPropertyByProductId(Long productId) {
		// TODO Auto-generated method stub
		return "fallback-error";
	}

	@Override
	public String findProductById(Long id) {
		// TODO Auto-generated method stub
		return "fallback-error";
	}

	@Override
	public String findProductSpecificationById(Long id) {
		// TODO Auto-generated method stub
		return "fallback-error";
	}

	@Override
	public String findProductSpecificationByProductId(Long productId) {
		// TODO Auto-generated method stub
		return "fallback-error";
	}

	
}
