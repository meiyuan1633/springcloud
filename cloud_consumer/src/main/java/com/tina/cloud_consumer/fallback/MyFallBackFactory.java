package com.tina.cloud_consumer.fallback;

import com.tina.cloud_consumer.service.StudentSignService;
import com.tina.cloud_model.dto.SignDto;
import com.tina.cloud_model.vo.R;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component//IOC创建
public class MyFallBackFactory implements FallbackFactory<StudentSignService> {
    @Override
    public StudentSignService create(Throwable throwable) {
        //匿名内部类
        return new StudentSignService() {
            @Override
            public R save(SignDto dto) {
                return R.fail("服务不可用-save");
            }

            @Override
            public R names(String name) {
                return R.fail("服务不可用-names:"+name);
            }

            @Override
            public R all() {
                return R.fail("服务不可用-all");
            }
        };
    }
}
