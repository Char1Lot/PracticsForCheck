package ru.chariot.dictionary.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "REST API by Elistratov Denis",
                description = "My first experience in REST API Applications",
                contact = @Contact(
                        name = "Elistratov Denis",
                        email = "deniska2003elistratov@mail.ru"
                )
        )
)
public class openApiConfig {
}
