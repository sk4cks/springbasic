package toby_project.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "toby_project.config.autoconfig.DispatcherServletConfig",
                "toby_project.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
