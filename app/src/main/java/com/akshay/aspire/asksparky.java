package com.akshay.aspire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class asksparky extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView txtwlcome;
    EditText edtmessage;
    ImageButton btnsend;
    List<Message> messageList;
    MessageAdapter messageAdapter;

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asksparky);
        recyclerView =findViewById(R.id.chat_rv);
        txtwlcome =findViewById(R.id.txtWelcome);
        edtmessage =findViewById(R.id.message_edit_text);
        btnsend =findViewById(R.id.send_btn);

        messageList=new ArrayList<>();
        messageAdapter=new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question=edtmessage.getText().toString().trim();
                addToChat(question,Message.SENT_BY_ME);

                try {
                    callAPI(question);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                txtwlcome.setVisibility(view.GONE);

            }
        });

    }

    void addToChat(String message,String sendby){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message(message,sendby));
                messageAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });
    }
    void  addResponse(String response){
        messageList.remove(messageList.size()-1);
        addToChat(response,Message.SENT_BY_BOT);
    }

    void callAPI(String question) throws JSONException {
        messageList.add(new Message("Typing.....",Message.SENT_BY_BOT));
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("model","gpt-3.5-turbo");
            JSONArray msgarr=new JSONArray();
            JSONObject obj=new JSONObject();
            obj.put("role","user");
            obj.put("context","question");
            msgarr.put(obj);
            jsonObject.put("message",msgarr);
        }
        catch (JSONException e){
            throw new RuntimeException(e);
        }
        RequestBody body=RequestBody.create(jsonObject.toString(),JSON);
        Request request=new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .header("Authorization","Bearer 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")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                addResponse("Fail to load message due to "+e.getMessage());

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    try {
                        JSONObject jsonObject1=new JSONObject(response.body().toString());
                        JSONArray jsonArray=null;
                        jsonArray=jsonObject1.getJSONArray("choices");
                        String results=jsonArray.getJSONObject(0)
                                .getJSONObject("message")
                                .getString("content");
                        addResponse(results.trim());

                    }catch (JSONException e){
                        throw new RuntimeException(e);
                    }
                }
                else {
                    addResponse("Failed to load due to"+response.body().toString());
                }

            }
        });
    }


}