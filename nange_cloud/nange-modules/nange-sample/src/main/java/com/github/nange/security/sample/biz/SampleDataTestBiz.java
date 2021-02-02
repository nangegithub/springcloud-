package com.github.nange.security.sample.biz;

import com.github.nange.security.common.biz.BaseBiz;
import com.github.nange.security.sample.entity.SampleDataTest;
import com.github.nange.security.sample.mapper.SampleDataTestMapper;
import org.springframework.stereotype.Service;

@Service
public class SampleDataTestBiz extends BaseBiz<SampleDataTestMapper, SampleDataTest> {
}