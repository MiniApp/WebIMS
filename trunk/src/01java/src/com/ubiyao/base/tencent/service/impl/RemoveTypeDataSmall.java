/*
 * Copyright 2012 Trinea.com All right reserved. This software is the
 * confidential and proprietary information of Trinea.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Trinea.com.
 */
package com.ubiyao.base.tencent.service.impl;

import com.ubiyao.base.tencent.entity.CacheObject;
import com.ubiyao.base.tencent.service.CacheFullRemoveType;
import com.ubiyao.base.tencent.util.ObjectUtils;

/**
 * 缓存满时删除数据的类型--对象值小先删除
 * 
 * @author Trinea 2012-5-10 上午01:15:50
 */
public class RemoveTypeDataSmall<T> implements CacheFullRemoveType<T> {

    private static final long serialVersionUID = 1L;

    @Override
    public int compare(CacheObject<T> obj1, CacheObject<T> obj2) {
        return ObjectUtils.compare(obj1.getData(), obj2.getData());
    }
}
