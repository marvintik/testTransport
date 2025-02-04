package testTransport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
  @Bean
  public Docket postsApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo()).select().paths(s -> s.contains("api")).build();
  }

  private Predicate<String> postPaths() {
    return regex("*/api*");
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Транспорт тест API")
            .description("Тестове завдання. Створення API до бази данних").build();
  }
}