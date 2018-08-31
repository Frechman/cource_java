--CREATE DATABASE tracker_db;

CREATE TABLE IF NOT EXISTS Items (
  id          SERIAL PRIMARY KEY,
  name        VARCHAR(256) NOT NULL,
  description TEXT,
  create_date TIMESTAMP DEFAULT now()
);
