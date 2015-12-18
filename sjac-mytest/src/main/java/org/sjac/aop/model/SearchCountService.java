package org.sjac.aop.model;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.sjac.model.GroupDAO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class SearchCountService {
	@Resource
	private GroupDAO groupDAO;

	@After("execution(public * org.sjac.model.GroupService.findGroupListByGNameAndGInfo(..)) or execution(public * org.sjac.model.GroupService.findGroupList(..)) or execution(public * org.sjac.model.GroupService.findGroupByLeaderId(..))")
	public void updateSearchCount() {
		groupDAO.updateSearchCount();
	}

}
