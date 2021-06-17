package org.apache.flink.kubernetes.operator.crd;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.apache.flink.kubernetes.operator.crd.spec.FlinkApplicationSpec;
import org.apache.flink.kubernetes.operator.crd.status.FlinkApplicationStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize()
@Version(FlinkApplication.VERSION)
@Group(FlinkApplication.GROUP)
public class FlinkApplication extends CustomResource {
    public static final String GROUP = "flink.k8s.io";
    public static final String VERSION = "v1alpha1";

    private FlinkApplicationSpec spec;
    private FlinkApplicationStatus status;

    public FlinkApplicationSpec getSpec() {
        return spec;
    }

    public void setSpec(FlinkApplicationSpec spec) {
        this.spec = spec;
    }

    public FlinkApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(FlinkApplicationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FlinkApplication{"+
                "apiVersion='" + getApiVersion() + "'" +
                ", metadata=" + getMetadata() +
                ", spec=" + spec +
                ", status=" + status +
                "}";
    }

    @Override
    public ObjectMeta getMetadata() {
        return super.getMetadata();
    }
}
