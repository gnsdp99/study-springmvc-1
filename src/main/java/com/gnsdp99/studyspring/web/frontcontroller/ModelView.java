package com.gnsdp99.studyspring.web.frontcontroller;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ModelView {

    private final String viewName;
    private final Map<String, Object> model;

    public ModelView(String viewName) {
        this.viewName = viewName;
        model = new HashMap<>();
    }

    public ModelView(String viewName, Map<String, Object> model) {
        this.viewName = viewName;
        this.model = model;
    }
}
