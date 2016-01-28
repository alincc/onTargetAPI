package com.ontarget.api.repository;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 * Created by sanjeevghimire on 1/27/16.
 */

@NamedStoredProcedureQuery(
        name = "createSampleProject",
        procedureName = "create_sample_project",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "userId"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Boolean.class, name = "done")
        }
)
public class CreateSampleProject{
}
