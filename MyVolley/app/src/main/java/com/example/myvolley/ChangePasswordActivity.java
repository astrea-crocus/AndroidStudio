package com.example.myvolley;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText editTextOldPassword, editTextNewPassword, editTextConfirmPassword;
    private Button buttonChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        String userId = getIntent().getStringExtra("USER_ID");
        Log.d("ChangePasswordActivity", "Received userId: " + userId);


        // Initialize views
        editTextOldPassword = findViewById(R.id.editTextOldPassword);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonChangePassword = findViewById(R.id.buttonChangePassword);

        // Set onClickListener for change password button
        buttonChangePassword.setOnClickListener(v -> changePassword(userId));
    }

    private void changePassword(String userId) {
        String oldPassword = editTextOldPassword.getText().toString().trim();
        String newPassword = editTextNewPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        // Validate input fields
        if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(ChangePasswordActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(ChangePasswordActivity.this, "New passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Send the new password to the server
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.1.231/myVolley/change_password.php",
                response -> {
                    Log.d("Response", response);  // Log the entire response
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String status = jsonObject.getString("status");
                        String message = jsonObject.getString("message");

                        if (status.equals("success")) {
                            Toast.makeText(ChangePasswordActivity.this, message, Toast.LENGTH_SHORT).show();
                            // Optionally, you can navigate away or update the UI.
                        } else {
                            Toast.makeText(ChangePasswordActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(ChangePasswordActivity.this, "JSON Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Toast.makeText(ChangePasswordActivity.this, "Request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("user_id", userId); // Ensure the userId is not empty
                params.put("old_password", oldPassword); // Ensure the oldPassword is not empty
                params.put("new_password", newPassword); // Ensure newPassword is not empty
                return params;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(ChangePasswordActivity.this);
        queue.add(stringRequest);
    }

}