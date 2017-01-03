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

package org.talend.components.pubsub.runtime;

import org.talend.components.pubsub.PubSubDatasetProperties;
import org.talend.components.pubsub.PubSubDatastoreProperties;
import org.talend.components.pubsub.input.PubSubInputProperties;

public class PubSubTestConstants {

    public static final String PROJECT;

    public static final String SERVICE_ACCOUNT_FILE;

    static {
        PROJECT = System.getProperty("bigquery.project");
        SERVICE_ACCOUNT_FILE = System.getProperty("bigquery.service.account.file");
    }

    public static PubSubDatastoreProperties createDatastore() {
        PubSubDatastoreProperties datastore = new PubSubDatastoreProperties("datastore");
        datastore.init();
        datastore.projectName.setValue(PubSubTestConstants.PROJECT);
        datastore.serviceAccountFile.setValue(PubSubTestConstants.SERVICE_ACCOUNT_FILE);
        return datastore;
    }

    public static PubSubDatasetProperties createDataset(PubSubDatastoreProperties datastore) {
        PubSubDatasetProperties dataset = new PubSubDatasetProperties("dataset");
        dataset.init();
        dataset.setDatastoreProperties(datastore);
        return dataset;
    }

    public static PubSubDatasetProperties createDatasetFromCSV(PubSubDatastoreProperties datastore, String fieldDelimited) {
        PubSubDatasetProperties dataset = createDataset(datastore);
        dataset.valueFormat.setValue(PubSubDatasetProperties.ValueFormat.CSV);
        dataset.fieldDelimiter.setValue(fieldDelimited);
        return dataset;
    }

    public static PubSubDatasetProperties createDatasetFromAvro(PubSubDatastoreProperties datastore, String schema) {
        PubSubDatasetProperties dataset = createDataset(datastore);
        dataset.valueFormat.setValue(PubSubDatasetProperties.ValueFormat.AVRO);
        dataset.avroSchema.setValue(schema);
        return dataset;
    }

    public static PubSubInputProperties createInput(PubSubDatasetProperties dataset, String subscription, Long maxTime,
            Integer maxNum) {
        PubSubInputProperties input = new PubSubInputProperties("input");
        input.init();
        input.setDatasetProperties(dataset);
        if (maxTime != null) {
            input.useMaxReadTime.setValue(true);
            input.maxReadTime.setValue(maxTime);
        }
        if (maxNum != null) {
            input.useMaxNumRecords.setValue(true);
            input.maxNumRecords.setValue(maxNum);
        }
        input.subscription.setValue(subscription);
        return input;
    }

}