package com.tickets.application.user.dao;

import com.tickets.application.user.validaor.email.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

/**
 * User data access object.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {

    private UUID id;

    @NotBlank(message = "Name is the mandatory attribute")
    @Size(min = 2, max = 128, message = "Name should have a length between 2 and 128 characters")
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)(?!.*?--)[A-Za-z\\s-]*$",
                message = "First name can only contain Latin letters, spaces, and hyphens")
    private String name;

    @UniqueEmail
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email should have a length between 2 and 128 characters")
    private String email;

    @NotBlank(message = "Password is the mandatory attribute")
    @Size(min = 8, max = 128, message = "Password should have a length between 8 and 128 characters")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password must be at least 8 characters long and "
                + "contain at least one letter, one digit, and may include special characters @$!%*?&")
    private String password;

    private List<UUID> ticketIds;
}
