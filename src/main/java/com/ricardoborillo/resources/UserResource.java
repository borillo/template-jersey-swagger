package com.ricardoborillo.resources;

import com.ricardoborillo.model.User;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users.json")
@Api(value = "/users", description = "User management interface")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource
{
    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Find user by id",
            notes = "Only users registered as external should be accessed",
            responseClass = "com.ricardoborillo.model.User")
    @ApiErrors(value = {
            @ApiError(code = 400, reason = "Invalid id supplied"),
            @ApiError(code = 404, reason = "User not found")
    })
    public User getUserById(
            @ApiParam(value = "Id of the user that needs to be fetched",
                    allowableValues = "range[1,999]",
                    required = true) @PathParam("userId") String userId)
    {
        User user = new User();
        user.setId(1L);
        user.setName("Ricardo Borillo");

        return user;
    }
}