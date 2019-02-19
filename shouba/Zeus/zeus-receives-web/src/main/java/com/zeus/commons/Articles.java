package com.zeus.commons;

import com.zeus.entity.Article;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @author:wangdi
 * @date:2019/1/10
 * @ver:1.0
 */
@Data
public class Articles {

    public  Long userId;
    public List<Article> article;
}
