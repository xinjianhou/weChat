/**
 * @Title: BeanMapperService.java
 * @Package com.shunxin.web.dozer
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 17, 2018 2:56:57 PM
 * @version V1.0
 */

package com.shunxin.web.dozer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: BeanMapperService</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 17, 2018
 */
@Service
public class BeanMapperService {

	/**
	 * @Fields beanMapper : TODO
	 */
	@Autowired
	private Mapper beanMapper;

	/**
	 * <p>Title: copy </p>
	 * <p>Description: 基于Dozer将对象A的值拷贝到对象B中.</p>
	 * @param source
	 * @param destinationObject
	 */
	public void copy(final Object source, final Object destinationObject) {
		beanMapper.map(source, destinationObject);
	}

	/**
	 * <p>Title: mapper </p>
	 * <p>Description: 基于Dozer转换对象的类型.</p>
	 * @param source
	 * @param destinationClass
	 * @return
	 */
	public <T> T mapper(final Object source, final Class<T> destinationClass) {
		return beanMapper.map(source, destinationClass);
	}

	//.
	/**
	 * <p>Title: mapperList </p>
	 * <p>Description: 基于Dozer转换Collection中对象的类型</p>
	 * @param sourceList
	 * @param destinationClass
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> List<T> mapperList(final Collection sourceList, final Class<T> destinationClass) {
		final List<T> destinationList = new ArrayList<>();
		for (final Object sourceObject : sourceList) {
			final T destinationObject = beanMapper.map(sourceObject, destinationClass);
			destinationList.add(destinationObject);
		}
		return destinationList;
	}

}