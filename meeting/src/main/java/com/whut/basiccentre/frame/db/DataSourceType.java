package com.whut.basiccentre.frame.db;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataSourceType {
    READ("read", "从库"),
    WRITE("write", "主库");
    private String type;
    private String name;

}