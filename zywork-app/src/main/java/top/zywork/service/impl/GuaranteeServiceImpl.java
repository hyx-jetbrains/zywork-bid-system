package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GuaranteeDAO;
import top.zywork.dos.GuaranteeDO;
import top.zywork.dto.GuaranteeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GuaranteeService;

import javax.annotation.PostConstruct;

/**
 * GuaranteeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-29<br/>
 *
 * @author http://zywork.top 危锦辉
 * @version 1.0
 */
@Service(value = "guaranteeService")
public class GuaranteeServiceImpl extends AbstractBaseService implements GuaranteeService {

    private GuaranteeDAO guaranteeDAO;

    @Autowired
    public void setGuaranteeDAO(GuaranteeDAO guaranteeDAO) {
        super.setBaseDAO(guaranteeDAO);
        this.guaranteeDAO = guaranteeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GuaranteeDO.class, GuaranteeDTO.class);
    }
}
