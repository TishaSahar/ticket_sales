CREATE TABLE IF NOT EXISTS tickets
(
    id UUID PRIMARY KEY,
    user_id UUID,
    route_id UUID NOT NULL,
    date_time TIMESTAMP NOT NULL,
    pass_number INT NOT NULL,
    price INT NOT NULL,

    CONSTRAINT fk_tickets_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE
);
