package com.parsable.appetizer.parasable.Network;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.CreatApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LoginApiPojo;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Davix on 3/9/16.
 */
public interface IWebApiService{

    @Headers("Content-Type:application/json")
    @POST("api/authentication")
    Observable<ResponseBody> createAccount(@Body CreatApiPojo pojo);

    @Headers("Content-Type:application/json")
    @POST("api/authentication")
    Observable<AuthToken> loginAccount(@Body LoginApiPojo pojo);
//
//    @POST("/api/authentication")
//    fun logOutAccount(@Body body: IApiJsonPojo): Observable<Response>
//
//    @POST("/candidatestore/")
//    fun sendText(@Body body: IApiJsonPojo): Observable<Response>
//
//    @POST("/candidatestore/")
//    fun sendNum(@Body body: IApiJsonPojo): Observable<Response>
//
//
//    companion object {
//
//        var endPoint : String = "http://54.186.152.100"
//
//        internal object UserDeserializer : JsonDeserializer<CreatApiPojo> {
//            override fun deserialize(je : JsonElement, type : Type,
//                                     jdc: JsonDeserializationContext) : CreatApiPojo
//            {
//                val form = je.asJsonObject.get("form")
//                return Gson().fromJson(form, type)
//            }
//        }
//
//        fun create() : IWebApiServiceOld {
//            val gsonBuilder = GsonBuilder()
//            gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//            gsonBuilder.registerTypeAdapter(CreatApiPojo::class.java, UserDeserializer)
//
//            val url = endPoint
//            val restAdapter = retrofit2.Retrofit.Builder()
//                    .baseUrl(url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            return restAdapter.create(IWebApiServiceOld::class.java)
//        }
//    }
}
