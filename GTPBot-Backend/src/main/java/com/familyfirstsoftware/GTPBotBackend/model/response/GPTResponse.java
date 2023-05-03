package com.familyfirstsoftware.GTPBotBackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GPTResponse {

    public String id;
    public String object;
    public int created;
    public List<Choice> choices;
    public Usage usage;


}