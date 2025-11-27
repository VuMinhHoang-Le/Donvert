CREATE TABLE IF NOT EXISTS upload_receipt (
    receipt_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    file_id VARCHAR(255) NOT NULL,
    upload_time TIMESTAMP NOT NULL
);