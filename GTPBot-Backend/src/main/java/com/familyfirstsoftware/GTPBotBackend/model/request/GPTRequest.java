package com.familyfirstsoftware.GTPBotBackend.model.request;

import com.familyfirstsoftware.GTPBotBackend.model.common.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GPTRequest {

    private String model;
    private List<Message> messages;
    private Integer max_tokens;

}