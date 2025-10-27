use opentelemetry::global;
use opentelemetry_otlp;
use opentelemetry_sdk::{
    propagation::TraceContextPropagator,
    resource::{EnvResourceDetector, Resource},
    runtime, trace as sdktrace,
};
use std::time::Duration;

fn get_resource_attr() -> Resource {
    let env_resource = EnvResourceDetector::new().detect();
    env_resource
}

pub fn init_tracer() {
    global::set_text_map_propagator(TraceContextPropagator::new());

    opentelemetry_otlp::new_exporter()
        .tonic()
        .build_trace_pipeline()
        .with_trace_config(sdktrace::Config::default().with_resource(get_resource_attr()))
        .install_batch(runtime::Tokio)
        .expect("pipeline install error");
}
