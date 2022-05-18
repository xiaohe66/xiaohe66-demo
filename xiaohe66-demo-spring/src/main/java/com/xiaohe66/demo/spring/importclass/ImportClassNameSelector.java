package com.xiaohe66.demo.spring.importclass;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xiaohe
 * @since 2022.05.18 09:49
 */
public class ImportClassNameSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.xiaohe66.demo.spring.importclass.ImportClassConfigure"};
    }
}
