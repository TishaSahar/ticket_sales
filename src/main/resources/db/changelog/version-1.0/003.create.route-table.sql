CREATE TABLE IF NOT EXISTS routes
(
    id UUID PRIMARY KEY,
    carrier_id UUID NOT NULL,
    departure_point VARCHAR(30) NOT NULL,
    destination_point VARCHAR(30) NOT NULL,
    duration_minutes INT,
    capacity INT NOT NULL,

    CONSTRAINT fr_routes_carrier
        FOREIGN KEY (carrier_id)
            REFERENCES carriers (id)
            ON DELETE CASCADE
);