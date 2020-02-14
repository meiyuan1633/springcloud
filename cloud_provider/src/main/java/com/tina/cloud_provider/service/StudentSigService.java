package com.tina.cloud_provider.service;

import com.tina.cloud_model.dto.SignDto;
import com.tina.cloud_model.vo.R;

public interface StudentSigService {
    R sign(SignDto dto);
    R queryByName(String name);
    R queryAll();

}
