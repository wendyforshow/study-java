/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.sharding.jdbc.algorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.sharding.jdbc.algorithm
 * 功能：
 * 时间：2016-07-16 0:16
 * 作者：Mr.Kiwi
 */

public final class SingleKeyModuloDatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Integer> {

    @Override
    public String doEqualSharding(final Collection<String> availableTargetNames, final ShardingValue<Integer> shardingValue) {
        for (String each : availableTargetNames) {
            if (each.endsWith(shardingValue.getValue() % 2 + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> doInSharding(final Collection<String> availableTargetNames, final ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        Collection<Integer> values = shardingValue.getValues();
        for (Integer value : values) {
            for (String dataSourceName : availableTargetNames) {
                if (dataSourceName.endsWith(value % 2 + "")) {
                    result.add(dataSourceName);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(final Collection<String> availableTargetNames, final ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        Range<Integer> range = shardingValue.getValueRange();
        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : availableTargetNames) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
