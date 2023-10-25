package at.grid.emailservice.Rest;

import at.grid.emailservice.Dto.EmailDto;
import at.grid.emailservice.Service.EmailService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/email")
@Produces(MediaType.APPLICATION_JSON)
public class EmailController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendEmail(EmailDto dto) {
        EmailService service = new EmailService();
        service.sendEmail(dto.from, dto.to, dto.subject, dto.body);
        return Response.status(Response.Status.OK).entity(dto).build();
    }


}
