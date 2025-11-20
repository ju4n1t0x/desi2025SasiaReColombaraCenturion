package tuti.desi.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(title = "Tuti Daos TP",
                description = "Trabajo practico final Daos",
                license = @License(name = "Standard Software", url = "https://github.com/ju4n1t0x/license"),
                version = "1.0.0",
                contact = @Contact(name = "Juan Sasia", email = "juanignaciosasia@gmail.com", url = "https://github.com/ju4n1t0x"))

)
public class SwaggerConfig {}
