package com.github.nange.config;


import com.github.nange.search.lucene.LuceneDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Description:s
 **/
@Configuration
public class LuceneConfiguration {
    @Value("${search.lucence.path}")
    private String lucencePath;

    @Bean
    public LuceneDao luceneUtil() throws IOException {
        LuceneDao luceneDao = new LuceneDao();
        luceneDao.setIndexDer(lucencePath);
        return luceneDao;
    }

}
