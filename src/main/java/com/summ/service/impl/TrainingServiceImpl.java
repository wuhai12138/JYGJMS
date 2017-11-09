package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.TrainingMapper;
import com.summ.model.Training;
import com.summ.service.ITrainingService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Training 表数据服务层接口实现类
 *
 */
@Service
public class TrainingServiceImpl extends SuperServiceImpl<TrainingMapper, Training> implements ITrainingService {


}