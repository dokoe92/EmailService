package com.gridapp.emailservice.rest;

import com.gridapp.emailservice.dto.EmailDto;
import com.gridapp.emailservice.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/email")
@Produces(MediaType.APPLICATION_JSON)
public class EmailEndpoint
{

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendEmail(EmailDto dto)
    {
        EmailService service = new EmailService();
        try
        {
            service.sendEmail(dto.from, dto.to, dto.subject, dto.body);
            return Response.status(Response.Status.OK).entity(dto).build();
        } catch (MessagingException e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }


    }


}
