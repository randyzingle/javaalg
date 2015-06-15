--liquibase formatted sql

--changeset nfisher:2
CREATE TABLE clicks (
  clicktime TIMESTAMP,        -- time of the event
  item_clicked VARCHAR(255)   -- the button id or URL clicked
);

--rollback DROP TABLE clicks;