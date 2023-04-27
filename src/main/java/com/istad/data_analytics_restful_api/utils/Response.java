package com.istad.data_analytics_restful_api.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.catalina.Session;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Response<T> {
    public enum Status{
        OK, BAD_REQUEST, UNAUTHORIZED, EXCEPTION,
        VALIDATION_EXCEPTION, WRONG_CREDENTIAL, ACCESS_DENIED,
        NOT_FOUND, DUPLICATE_ENTRY, SUCCESS_DELETE, CREATE_SUCCESS ,
        UPDATE_SUCCESS
    }
    private T payload;
    private Object message;
    private boolean success = false;
    private  Object metadata;
    private Status status;
    public static <T>Response<T>ok(){
        Response<T>response=new Response<>();
        response.setStatus(Status.OK);
        response.setSuccess(true);
        return response;
    }

    public static <T> Response<T> createSuccess(){
        Response<T>response=new Response<>();
        response.setStatus(Status.CREATE_SUCCESS);
        response.setSuccess(true);
        return response;

    }
    public static <T> Response<T>updateSuccess(){
        Response<T>response = new Response<>();
        response.setStatus(Status.UPDATE_SUCCESS);
        response.setSuccess(true);
        return response;
    }
    public static <T> Response<T>deleteSuccess(){
        Response<T>response=new Response<>();
        response.setStatus(Status.SUCCESS_DELETE);
        response.setSuccess(true);
        return response;
    }
    public static <T> Response<T>notFound(){
        Response<T>response=new Response<>();
        response.setStatus(Status.NOT_FOUND);
        response.setSuccess(true);
        return response;
    }
    public static <T> Response<T>exception(){
        Response<T>response=new Response<>();
        response.setStatus(Status.EXCEPTION);
        return response;
    }

}
