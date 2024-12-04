package com.gnsdp99.studyspring.web.frontcontroller.v3;

import com.gnsdp99.studyspring.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
