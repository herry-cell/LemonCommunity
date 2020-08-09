package com.sgldts.community.dto;

import com.sgldts.community.model.User;
import lombok.Data;

/**
 * @author herry
 * @create 2020-08-09-22:12
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
