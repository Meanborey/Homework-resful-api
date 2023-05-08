package com.istad.data_analytics_restful_api.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    @NotBlank(message = "Username is request !")
    private String username;
    @NotBlank(message = "Gender id also required !")
    private String gender;
    private String address;


}
