package com.testcraftsmanship;

import com.testcraftsmanship.clientsidecert.base.BaseTest;
import com.testcraftsmanship.clientsidecert.pages.AuthenticationPage;
import org.junit.After;
import org.junit.Test;

import static com.testcraftsmanship.clientsidecert.authentication.UserType.CUSTOMER;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClientSideCertificateTest extends BaseTest {

    @Test
    public void itShouldBePossibleToAuthenticateWithClientCert() {
        AuthenticationPage page = openApplicationAs(CUSTOMER);
        String authenticationInfo = page.getAuthenticationInfo();
        assertThat(authenticationInfo, equalTo("This site requires a client-authenticated TLS handshake."));
    }

    @After
    public void cleanUp() {
        closeApplication();
    }
}