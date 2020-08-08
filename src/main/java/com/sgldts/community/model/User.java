package com.sgldts.community.model;

import lombok.Data;

/**
 * @author herry
 * @create 2020-08-08-16:35
 */

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
}
