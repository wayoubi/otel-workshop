use actix_web::{App, HttpServer};
use actix_web_opentelemetry::RequestTracing;

mod telemetry_conf;
use telemetry_conf::init_tracer;

mod data_processing;
use data_processing::process_temp;

use tracing_subscriber;

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    tracing_subscriber::fmt().json().init();

    init_tracer();

    HttpServer::new(|| App::new().wrap(RequestTracing::new()).service(process_temp))
        .bind(("0.0.0.0", 9000))?
        .run()
        .await
}
