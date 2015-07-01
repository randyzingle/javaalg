--liquibase formatted sql


--changeset nfisher:3
ALTER TABLE burst.clicks
  ADD session VARCHAR(255);       -- the session or user ID

--rollback ALTER TABLE burst.clicks DROP session;