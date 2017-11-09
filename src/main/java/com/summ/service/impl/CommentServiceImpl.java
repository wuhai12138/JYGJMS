package com.summ.service.impl;

import org.springframework.stereotype.Service;

import com.summ.mapper.CommentMapper;
import com.summ.model.Comment;
import com.summ.service.ICommentService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Comment 表数据服务层接口实现类
 *
 */
@Service
public class CommentServiceImpl extends SuperServiceImpl<CommentMapper, Comment> implements ICommentService {


}