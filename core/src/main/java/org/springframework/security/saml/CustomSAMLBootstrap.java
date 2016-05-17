package org.springframework.security.saml;

import org.opensaml.xml.Configuration;
import org.opensaml.xml.security.BasicSecurityConfiguration;

import java.util.Map;

public class CustomSAMLBootstrap {
    public CustomSAMLBootstrap(Map<String, String> signatureAlgorithms, String signatureDigestMethod) {
        BasicSecurityConfiguration config = (BasicSecurityConfiguration) Configuration.getGlobalSecurityConfiguration();

        for (Map.Entry<String, String> entry: signatureAlgorithms.entrySet()) {
            String algoName = entry.getKey();
            String algoURI = entry.getValue();

            config.registerSignatureAlgorithmURI(algoName, algoURI);
        }

        config.setSignatureReferenceDigestMethod(signatureDigestMethod);
    }
}
