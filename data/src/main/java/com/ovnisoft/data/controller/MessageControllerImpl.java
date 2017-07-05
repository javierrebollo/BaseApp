package com.ovnisoft.data.controller;


import com.ovnisoft.data.entity.Message;
import com.ovnisoft.data.requests.RequestUrls;
import com.ovnisoft.data.requests.ServerRequest;

import java.util.List;

/**
 * Created by javier_rebollo on 14/11/16.
 */

public class MessageControllerImpl implements MessageController {

    private ServerRequest<Message> mMessageServerRequest;
    private ServerRequest<List<Message>> mMessageServerRequestList;

    public MessageControllerImpl(ServerRequest<Message> messageServerRequest) {
        mMessageServerRequest = messageServerRequest;
        mMessageServerRequest = messageServerRequest;
    }

    @Override
    public Message getMessage() {
        return mMessageServerRequest.getRequest(
                RequestUrls.GET_ENTITY_EXAMPLE + entityExample.getUserId()
        );
    }

    public List<Message> getAllMessages() {
        return mMessageServerRequest.getRequest(
                RequestUrls.GET_ENTITY_EXAMPLE + entityExample.getUserId()
        );
    }
}
