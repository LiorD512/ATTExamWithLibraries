package com.att.attexamwithlibraries;

import com.att.attexamwithlibraries.api.ContactApi;
import com.att.attexamwithlibraries.model.Contact;
import com.att.attexamwithlibraries.model.ContactList;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;

public class RetrofitUnitTest {

    @Test
    public void testApiResponse() {
        ContactApi mockedApiInterface = Mockito.mock(ContactApi.class);
        final Call<ContactList> mockedCall = Mockito.mock(Call.class);

        Mockito.when(mockedApiInterface.getTenContacts()).thenReturn(mockedCall);

        Mockito.doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Callback<ContactList> callback = invocation.getArgument(0);

                callback.onResponse(mockedCall, Response.success(new ContactList()));
                // or callback.onResponse(mockedCall, Response.error(404. ...);
                // or callback.onFailure(mockedCall, new IOException());

                return null;
            }
        }).when(mockedCall).enqueue(any(Callback.class));

        // inject mocked ApiInterface to your presenter
        // and then mock view and verify calls (and eventually use ArgumentCaptor to access call parameters)
    }
}
