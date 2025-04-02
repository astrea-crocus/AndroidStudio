package com.example.myvolley;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyRequest {

    private Context context;
    private RequestQueue queue;

    public MyRequest(Context context, RequestQueue queue) {
        this.context = context;
        this.queue = queue;
    }

    public void register(final String LOGIN,
                         final String EMAIL,
                         final String PASSWORD,
                         final String PASSWORD2,
                         final RetoursPHP rP) {
        String url = "http://192.168.1.231/myVolley/register.php";

        final StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("PHP", response);
                        Map<String, String> erreurPHP = new HashMap<>();
                        try {
                            JSONObject json = new JSONObject(response);
                            Boolean error = json.getBoolean("error");

                            if (!error) {
                                rP.toutOK("Félicitation ! Votre compte a été créé");
                            } else {
                                rP.pasOK(json.getString("message"));
                                Log.d("PHP", "Passage rp.PasOK dans MyRegister");
                            }

                        } catch (JSONException e) {
                            Log.d("PHP", "Passage dans le catch de register : " + e);
                            rP.systemError("Une erreur est survenue, veuillez renouveler votre essai.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if ((error instanceof NetworkError)) {
                            rP.systemError("Une erreur réseau s'est produite," + "\n" +
                                    "impossible de joindre le serveur.");
                        } else if (error instanceof VolleyError) {
                            rP.systemError("Une erreur s'est produite, impossible de joindre le serveur.");
                        }
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("login", LOGIN);
                map.put("email", EMAIL);
                map.put("password", PASSWORD);
                map.put("password2", PASSWORD2);
                Log.d("PHP", "Envoie du map : " + map);
                return map;
            }
        };

        queue.add(request);
        Log.d("PHP", "Request : " + request);
    }

    public void login(final String EMAIL,
                      final String PASSWORD,
                      final loginPHP callback) {
        String url = "http://192.168.1.231/myVolley/login.php";

        final StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("PHP", response);
                        Map<String, String> erreurPHP = new HashMap<>();
                        try {
                            JSONObject json = new JSONObject(response);
                            Boolean error = json.getBoolean("error");

                            if (!error) {
                                String id = json.getString("id");
                                String pseudo = json.getString("pseudo");
                                String email = json.getString("email");

                                Log.d("PHP", id + pseudo + email);

                                callback.toutOK(id, pseudo, email, "Connexion réussie.");

                            } else {
                                callback.pasOK(json.getString("message"));
                                Log.d("PHP", "Passage rp.PasOK dans MyLogin");
                            }

                        } catch (JSONException e) {
                            Log.d("PHP", "Passage dans le catch de login : " + e);
                            callback.systemError("Une erreur est survenue, veuillez renouveler votre essai.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if ((error instanceof NetworkError)) {
                            callback.systemError("Une erreur réseau s'est produite," + "\n" +
                                    "impossible de joindre le serveur.");
                        } else if (error instanceof VolleyError) {
                            callback.systemError("Une erreur s'est produite, impossible de joindre le serveur.");
                        }
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("email", EMAIL);
                map.put("password", PASSWORD);
                Log.d("PHP", "Envoie du map : " + map);
                return map;
            }
        };

        queue.add(request);
        Log.d("PHP", "Request : " + request);
    }

    /* ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */

    public interface RetoursPHP {
        void toutOK(String message);
        void pasOK(String message);
        void systemError(String message);
    }

    public interface loginPHP {
        void toutOK(String id, String pseudo, String email, String message);
        void pasOK(String message);
        void systemError(String message);

    }

}
