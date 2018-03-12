package com.css.spring.security;

import java.util.Hashtable;

import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

/**
 * @author Kishore Routhu on 12/3/18 3:48 PM.
 */
public class LdapSecurityContextSource extends DefaultSpringSecurityContextSource {

    private static final String CONNECTION_TIME_OUT_PROPERTY = "com.sun.jndi.ldap.connect.timeout";
    private static final String READ_TIME_OUT_PROPERTY = "com.sun.jndi.ldap.read.timeout";

    private static final String DEFAULT_TIME_OUT = "30000";

    /**
     * ProviderURL is ldap provider url
     * Here we can provide multiple callback urls as space separated
     * @param providerUrl
     */
    public LdapSecurityContextSource(String providerUrl) {
        super(providerUrl);
    }

    /**
     * Overriding this method to customize the connection properties with LDAP
     * such as ConnectionTimeOut and ReadTimeOut
     * Note: If we don't set this properties it will be infinite time.
     * @param principal
     * @param credentials
     * @return
     */
    @Override
    protected Hashtable<String, Object> getAuthenticatedEnv(String principal, String credentials) {
        Hashtable<String, Object> authenticatedEnv = super.getAuthenticatedEnv(principal, credentials);
        authenticatedEnv.put(CONNECTION_TIME_OUT_PROPERTY, DEFAULT_TIME_OUT);
        authenticatedEnv.put(READ_TIME_OUT_PROPERTY, DEFAULT_TIME_OUT);
        return authenticatedEnv;
    }
}
