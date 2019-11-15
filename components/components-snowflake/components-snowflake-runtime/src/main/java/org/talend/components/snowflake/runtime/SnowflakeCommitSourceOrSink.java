// ============================================================================
//
// Copyright (C) 2006-2019 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.components.snowflake.runtime;

import java.sql.Connection;
import java.sql.SQLException;

public class SnowflakeCommitSourceOrSink extends SnowflakeStandaloneOperation {

    @Override
    public void callOperation(Connection connection) throws SQLException {
        connection.commit();
    }
}
