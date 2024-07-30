package com.auditquery.service.impl;

import com.auditquery.entity.Pinpoint;
import com.auditquery.dao.PinpointMapper;
import com.auditquery.service.PinpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Pinpoint)表服务实现类
 *
 * @author makejava
 * @since 2024-02-22 22:15:39
 */
@Service
public class PinpointServiceImpl implements PinpointService {
    @Autowired
    private PinpointMapper pinpointMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Pinpoint queryById(Integer id) {
        return this.pinpointMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param pinpoint 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Pinpoint> queryByPage(Pinpoint pinpoint, PageRequest pageRequest) {
        long total = this.pinpointMapper.count(pinpoint);
        return new PageImpl<>(this.pinpointMapper.queryAllByLimit(pinpoint, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param pinpoint 实例对象
     * @return 实例对象
     */
    @Override
    public Pinpoint insertPinpoint(Pinpoint pinpoint) {
        this.pinpointMapper.insertPinpoint(pinpoint);
        return pinpoint;
    }

    /**
     * 修改数据
     *
     * @param pinpoint 实例对象
     * @return 实例对象
     */
    @Override
    public Pinpoint updatePinpoint(Pinpoint pinpoint) {
        this.pinpointMapper.updatePinpoint(pinpoint);
        return this.queryById(pinpoint.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByIdPinpoint(Integer id) {
        return this.pinpointMapper.deleteByIdPinpoint(id) > 0;
    }
}
