// ============================================================================
//
// Copyright (C) 2006-2017 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================

package org.talend.components.mongodb.integration;

import java.util.HashMap;
import java.util.Map;

import org.talend.components.api.container.RuntimeContainer;
import org.talend.components.mongodb.MongoDBConnectionProperties;

public abstract class MongoDBTestBasic {

    private static final String USER_ID = "talend";

    private static final String PASSWORD = "talend";

    private static final Integer MONGODB_PORT;

    static {
        String portStr = System.getProperty("mongodb.port");
        MONGODB_PORT = portStr != null ? Integer.parseInt(portStr) : 27017;
    }

    /**
     * @return the properties for this dataset, fully initialized with the default values and the datastore credentials
     * from the System environment.
     */
    public static MongoDBConnectionProperties createConnectionProperties() {

        MongoDBConnectionProperties properties = new MongoDBConnectionProperties("properties");
        properties.init();

        properties.port.setValue(MONGODB_PORT);
        // FIXME when docker of integrate is ready need recheck this.
        properties.userPassword.userId.setValue(USER_ID);
        properties.userPassword.password.setValue(PASSWORD);

        return properties;
    }

}
