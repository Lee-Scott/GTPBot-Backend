package com.familyfirstsoftware.GTPBotBackend.model.response;

import com.familyfirstsoftware.GTPBotBackend.model.common.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choice {

    public int index;
    public Message message;
    public String finish_reason;

    // Constructors, Getters and Setters
}
