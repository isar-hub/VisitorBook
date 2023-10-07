package com.visitorbook.Service;

import com.visitorbook.Models.user;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("emp")
    Call<user> getEmployeeData(
            @Query("userId") int userId,
            @Query("password") long password
    );
}
