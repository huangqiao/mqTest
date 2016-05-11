package com.test;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.service.PmsUserFacade;

/**
 * 
 * @描述: 用户登录  .
 * @作者: WuShuicheng .
 * @创建时间: 2015-1-25,下午7:50:22 .
 * @版本号: V1.0 .
 */
@Scope("prototype")
@Controller
public class PmsLoginAction {

	private static final Log log = LogFactory.getLog(PmsLoginAction.class);
	@Autowired
	private PmsUserFacade pmsUserFacade;

	/**
	 * 登录验证Action
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public void test() {
		pmsUserFacade.create();
	}
}
